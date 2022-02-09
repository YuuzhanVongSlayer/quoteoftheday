package edu.andrews.cptr252.aidanholmes.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AuthorFactActivity extends AppCompatActivity {
    private TextView mAuthorFactTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_fact);

        mAuthorFactTextView=findViewById(R.id.authorFactTextView);

        int authorFact=getIntent().getIntExtra(QuoteActivity.EXTRA_AUTHOR_FACT,R.string.fact_error);

        mAuthorFactTextView.setText(authorFact);
    }
}