package code.quotely;

import code.quotely.handler.IArgHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class QuotelyApplication {

    public static void main(String[] args) {
        try
        {
            ConfigurableApplicationContext app = SpringApplication.run(QuotelyApplication.class, args);

            IArgHandler argHandler = app.getBean(IArgHandler.class);
            System.out.println(argHandler.ParseArgument(args));
        }
        catch(Exception e)
        {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
    }
}
