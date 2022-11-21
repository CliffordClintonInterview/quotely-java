package code.quotely.model;

public class QuoteResponse
{
    public String quoteText;
    public String quoteAuthor;
    public String senderName;
    public String senderLink;
    public String quoteLink;

    public QuoteResponse ()
    {
        this.quoteText = "";
        this.quoteAuthor = "";
        this.senderLink = "";
        this.senderName = "";
        this.quoteLink = "";
    }

}
