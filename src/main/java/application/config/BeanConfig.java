package application.config;

import application.converters.Converter;
import application.exchange.Exchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Bean config
 */
@Configuration
@ComponentScan(basePackages="application")
public class BeanConfig{

    @Bean
    public Converter getConverter() {
        return new Converter();
    }

    @Bean
    public Exchange getExchange(){return new Exchange();}
}
