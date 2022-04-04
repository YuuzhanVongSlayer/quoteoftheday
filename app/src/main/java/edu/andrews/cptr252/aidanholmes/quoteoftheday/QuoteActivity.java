package edu.andrews.cptr252.aidanholmes.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;

/**
 * Main activity for the application.
 * Displays a series of quotes.
 */

public class QuoteActivity extends SingleFragmentActivity {
   protected Fragment createFragment(){return new QuoteFragment();}
}