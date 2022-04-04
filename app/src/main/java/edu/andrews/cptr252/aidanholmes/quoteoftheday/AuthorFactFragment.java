package edu.andrews.cptr252.aidanholmes.quoteoftheday;

import static edu.andrews.cptr252.aidanholmes.quoteoftheday.QuoteFragment.EXTRA_AUTHOR_FACT;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Activity that displays a fact about the author of a quote.
 */
public class AuthorFactFragment extends Fragment
{
    private TextView mAuthorFactTextView;
    private int authorFact;

    /**
     * Inflate layout. Display the fact sent by QuoteActivity
     * @param savedInstanceState Bundle object used to save activity state.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.activity_author_fact,container,false);

        mAuthorFactTextView=v.findViewById(R.id.authorFactTextView);

        authorFact=getActivity().getIntent().getIntExtra(EXTRA_AUTHOR_FACT,0);
        mAuthorFactTextView.setText(authorFact);
        return v;
    }

}