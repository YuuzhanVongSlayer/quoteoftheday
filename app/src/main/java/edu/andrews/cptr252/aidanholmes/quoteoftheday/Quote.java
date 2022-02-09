package edu.andrews.cptr252.aidanholmes.quoteoftheday;

/**Model for a quote.*/
public class Quote
{
    /**Reference to quote text.*/
    private int mQuote;

    /**Reference to quote's author*/
    private int mAuthor;


    private int mAuthorFact;

    /**
     *
     * @param quote
     * @param author
     */
    public Quote(int quote, int author, int authorFact)
    {
        mQuote=quote;
        mAuthor=author;
        mAuthorFact=authorFact;
    }

    public int getQuote(){return mQuote;}
    public void setQuote(int quote){mQuote=quote;}
    public int getAuthor() {return mAuthor;}
    public void setAuthor(int author) {mAuthor=author;}
    public int getAuthorFact(){return mAuthorFact;}
    public void setAuthorFact(int authorFact){mAuthorFact=authorFact;}

}
