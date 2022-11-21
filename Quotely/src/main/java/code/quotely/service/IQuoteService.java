package code.quotely.service;

import code.quotely.model.Quote;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface IQuoteService {
    Quote GetQuote(String language) throws JsonProcessingException;
}
