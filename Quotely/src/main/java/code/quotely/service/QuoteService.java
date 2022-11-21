package code.quotely.service;

import code.quotely.model.Quote;
import code.quotely.model.QuoteResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


import java.lang.runtime.ObjectMethods;
import java.net.http.HttpClient;

@Component
public class QuoteService implements IQuoteService {

    private String quoteApi = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json";

    @Override
    public Quote GetQuote(String language) throws JsonProcessingException {
        WebClient client = WebClient.create(String.format("%s&lang=%s", this.quoteApi, language));
        var responseString = client.get().retrieve().bodyToMono(String.class).block();

        ObjectMapper mapper = new ObjectMapper();

        QuoteResponse quoteResponse = mapper.readValue(responseString, QuoteResponse.class);
        return new Quote(quoteResponse.quoteText, quoteResponse.quoteAuthor);
    }
}
