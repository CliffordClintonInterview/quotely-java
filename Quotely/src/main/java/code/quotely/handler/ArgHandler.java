package code.quotely.handler;

import code.quotely.model.Quote;
import code.quotely.service.IQuoteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ArgHandler implements IArgHandler {
    private final IQuoteService quoteService;

    public ArgHandler(IQuoteService quoteService)
    {
        this.quoteService = quoteService;
    }

    @Override
    public String ParseArgument(String[] args) throws JsonProcessingException {
        String[] validLanguage = new String[] {"en", "ru"};

        var languageArg = args.length == 1 ? args[0] : "English";
        var language = languageArg.toLowerCase().substring(0,2);

        if(!Arrays.asList(validLanguage).contains(language))
        {
            return this.GetUsage();
        }

        Quote quote = this.quoteService.GetQuote(language);
        return quote.generateQuoteOutput();
    }

    private String GetUsage()
    {
        return "Quotely.Code [Russian | English]";
    }
}
