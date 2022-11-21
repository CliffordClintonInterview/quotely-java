package code.quotely.handler;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IArgHandler {
    String ParseArgument(String[] args) throws JsonProcessingException;
}
