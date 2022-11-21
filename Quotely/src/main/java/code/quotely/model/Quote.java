package code.quotely.model;

public record Quote(String QuoteText, String QuoteAuthor) {

    public Quote(String QuoteText, String QuoteAuthor)
    {
        this.QuoteText = QuoteText;
        this.QuoteAuthor = QuoteAuthor;
    }

    public String QuoteText() { return this.QuoteText; }

    public String QuoteAuthor() { return this.QuoteAuthor; }

    public String generateQuoteOutput() {
        return String.format("Quote: %s\nAuthor: %s", this.QuoteText, this.QuoteAuthor);
    }
}
