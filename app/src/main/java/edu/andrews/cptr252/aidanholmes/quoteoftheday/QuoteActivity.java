package edu.andrews.cptr252.aidanholmes.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;


public class QuoteActivity extends AppCompatActivity {
    public static final String EXTRA_AUTHOR_FACT=
            "edu.andrews.cptr252.rlsummerscales.quoteoftheday.author_fact";
    private static final String KEY_QUOTE_INDEX="quoteIndex";
    private TextView mQuoteTextView;
    private TextView mAuthorTextView;
    private Button mNextButton;

    /**Quotes Used*/
    private Quote[] mQuoteList=new Quote[]{
            new Quote(R.string.quote_text_0,R.string.quote_author_0,R.string.author_fact_0),
            new Quote(R.string.quote_text_1,R.string.quote_author_1,R.string.author_fact_1),
            new Quote(R.string.quote_text_2,R.string.quote_author_2,R.string.author_fact_2)
    };

    /**Index*/
    private int mCurrentIndex=0;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        // Store the index of the current quote in the bundle.
        // Use our key to access the value later.
        savedInstanceState.putInt(KEY_QUOTE_INDEX, mCurrentIndex);
    }

    /** Launch activity to display author fact*/
    private void displayAuthorFact() {


        Intent i = new Intent(QuoteActivity.this, AuthorFactActivity.class);

        i.putExtra(EXTRA_AUTHOR_FACT, mQuoteList[mCurrentIndex].getAuthorFact());

        startActivity(i);
    }

    /** Display the quote*/
    private void updateQuote()
    {
        int quote =mQuoteList[mCurrentIndex].getQuote();
        int author =mQuoteList[mCurrentIndex].getAuthor();

        mQuoteTextView.setText(quote);
        mAuthorTextView.setText(author);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        //Re-display the same quote we were on when activity destroyed.
        if(savedInstanceState!=null){
            mCurrentIndex= savedInstanceState.getInt(KEY_QUOTE_INDEX);
        }

        //get references to our textviews
        mQuoteTextView = findViewById(R.id.quoteTextView);
        mAuthorTextView = findViewById(R.id.authorTextView);

        updateQuote();

        // set up listeners to display author fact
        mQuoteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAuthorFact();
            }
        });

        mNextButton = findViewById(R.id.nextButton);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mCurrentIndex++;
                if (mCurrentIndex == mQuoteList.length) {
                    mCurrentIndex = 0;
                }
                updateQuote();
            }

            ;

        });
    }
}