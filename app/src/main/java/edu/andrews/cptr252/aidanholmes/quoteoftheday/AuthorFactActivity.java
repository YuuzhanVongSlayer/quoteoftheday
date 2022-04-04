package edu.andrews.cptr252.aidanholmes.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Activity that displays a fact about the author of a quote.
 */
public class AuthorFactActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment()
    {
     return new AuthorFactFragment();
    }
}