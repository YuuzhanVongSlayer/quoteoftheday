package edu.andrews.cptr252.aidanholmes.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;

/**
 * Main activity for the application.
 * Displays a series of quotes.
 */

public class QuoteFragment extends Fragment {
    /** Key for fact about author stored in Intent sent to AuthorFactActivity. */
    public static final String EXTRA_AUTHOR_FACT= "edu.andrews.cptr252.rlsummerscales.quoteoftheday.author_fact";
    private static final String KEY_QUOTE_INDEX="quoteIndex";
    private TextView mQuoteTextView;
    private TextView mAuthorTextView;
    private Button mNextButton;

    /** ImageView used to display inspirational image */
    private ImageView mImageView;


    /**Quotes Used*/
    private Quote[] mQuoteList=new Quote[]{
            new Quote(R.string.quote_text_0,R.string.quote_author_0,R.string.author_fact_0),
            new Quote(R.string.quote_text_1,R.string.quote_author_1,R.string.author_fact_1),
            new Quote(R.string.quote_text_2,R.string.quote_author_2,R.string.author_fact_2),
            new Quote(R.string.quote_text_3,R.string.quote_author_3,R.string.author_fact_3),
            new Quote(R.string.quote_text_4,R.string.quote_author_4,R.string.author_fact_4)

    };

    /**Index*/
    private int mCurrentIndex=0;

    /**
     * Remember the current quote when the activity is destroyed
     * @param savedInstanceState Bundle used for saving identity of current quote.
     */

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        // Store the index of the current quote in the bundle.
        // Use our key to access the value later.
        savedInstanceState.putInt(KEY_QUOTE_INDEX, mCurrentIndex);
    }



    /** Display the quote at the current index */
    private void updateQuote()
    {
        int quote =mQuoteList[mCurrentIndex].getQuote();
        int author =mQuoteList[mCurrentIndex].getAuthor();

        mQuoteTextView.setText(quote);
        mAuthorTextView.setText(author);

        //Homework (Adding new images)

        if(mCurrentIndex==0)
        {
            mImageView.setImageResource(R.drawable.mountain_pic);
        }
        if(mCurrentIndex==1)
        {
            mImageView.setImageResource(R.drawable.cheese);
        }
        if(mCurrentIndex==2)
        {
            mImageView.setImageResource(R.drawable.nel);
        }
        if(mCurrentIndex==3)
        {
            mImageView.setImageResource(R.drawable.iroh);
        }
        if(mCurrentIndex==4)
        {
            mImageView.setImageResource(R.drawable.bindo);
        }

        //end of homework code

    }

    /** Launch activity to display author fact*/
    private void displayAuthorFact() {


        Intent i = new Intent(getContext(), AuthorFactActivity.class);

        i.putExtra(EXTRA_AUTHOR_FACT, mQuoteList[mCurrentIndex].getAuthorFact());

        startActivity(i);
    }



    /**
     * Setup and inflate layout.
     * @param savedInstanceState Previously saved Bundle
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.activity_quote,container,false);

        //Re-display the same quote we were on when activity destroyed.
        if(savedInstanceState!=null){
            mCurrentIndex= savedInstanceState.getInt(KEY_QUOTE_INDEX);
        }

        // Display image
        mImageView = v.findViewById(R.id.imageView);
        mImageView.setImageResource(R.drawable.mountain_pic);


        //get references to our textviews
        mQuoteTextView = v.findViewById(R.id.quoteTextView);
        mAuthorTextView = v.findViewById(R.id.authorTextView);

        updateQuote();

        // set up listeners to display author fact
        mQuoteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAuthorFact();
            }
        });

        mNextButton = v.findViewById(R.id.nextButton);
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
        return v;
    }


}