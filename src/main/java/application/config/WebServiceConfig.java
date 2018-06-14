package application.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Webservice config
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "converter")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema converterSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ConverterPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://adammlynarczyk.xyz/webservice");
        wsdl11Definition.setSchema(converterSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema converterSchema() {
        return new SimpleXsdSchema(new ClassPathResource("converterScheme.xsd"));
    }

    @Bean(name = "exchange")
    public DefaultWsdl11Definition exchangeWsdl11Definition(XsdSchema exchangeSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ExchangePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://adammlynarczyk.xyz/exchange");
        wsdl11Definition.setSchema(exchangeSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema exchangeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("exchangeScheme.xsd"));
    }

}
