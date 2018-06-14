package application.endpoint;

import application.converters.Converter;
import application.exchange.Exchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xyz.adammlynarczyk.exchange.*;
import xyz.adammlynarczyk.webservice.*;

@Endpoint
public class ExchangeEndpoint {
    private Exchange exchanger;

    @Autowired
    public ExchangeEndpoint(Exchange exchanger){
        this.exchanger = exchanger;
    }

    Logger logger = LogManager.getLogger(ConverterEndpoint.class);

    /**
     * Method for pln to euro exchange. Returns SOAP response.
     * @param request
     * @return
     */
    @PayloadRoot(namespace = "http://adammlynarczyk.xyz/exchange", localPart = "getPlnToEuroRequest")
    @ResponsePayload
    public GetPlnToEuroResponse getPlnToEuro(@RequestPayload GetPlnToEuroRequest request){
        logger.info("Got new request for getPlnToEuro. Converting..");
        GetPlnToEuroResponse res = new GetPlnToEuroResponse();
        res.setEuro(exchanger.exchangePlnToEuro(request.getPln()));
        logger.info("Converted!");
        return res;
    }

    /**
     * Method for euro to pln exchange. Returns SOAP response.
     * @param request
     * @return
     */
    @PayloadRoot(namespace = "http://adammlynarczyk.xyz/exchange", localPart = "getEuroToPlnRequest")
    @ResponsePayload
    public GetEuroToPlnResponse getEuroToPln(@RequestPayload GetEuroToPlnRequest request){
        logger.info("Got new request for getEuroToPln. Converting..");
        GetEuroToPlnResponse res = new GetEuroToPlnResponse();
        res.setPln((exchanger.exchangeEuroToPln(request.getEuro())));
        logger.info("Converted!");
        return res;
    }

    /**
     * Method for pln to usd. Returns SOAP response.
     * @param request
     * @return
     */
    @PayloadRoot(namespace = "http://adammlynarczyk.xyz/exchange", localPart = "getPlnToUsdRequest")
    @ResponsePayload
    public GetPlnToUsdResponse getPlnToUsd(@RequestPayload GetPlnToUsdRequest request){
        logger.info("Got new request for getPlnToUsd. Converting..");
        GetPlnToUsdResponse res = new GetPlnToUsdResponse();
        res.setUsd((exchanger.exchangePlnToUsd(request.getPln())));
        logger.info("Converted!");
        return res;
    }

    /**
     * Method for usd to pln exchange. Returns SOAP response.
     * @param request
     * @return
     */
    @PayloadRoot(namespace = "http://adammlynarczyk.xyz/exchange", localPart = "getUsdToPlnRequest")
    @ResponsePayload
    public GetUsdToPlnResponse getUsdToPln(@RequestPayload GetUsdToPlnRequest request){
        logger.info("Got new request for getUsdToPln. Converting..");
        GetUsdToPlnResponse res = new GetUsdToPlnResponse();
        res.setPln((exchanger.exchangeUsdToPln(request.getUsd())));
        logger.info("Converted!");
        return res;
    }

    /**
     * Method for pln to pounds exchange. Returns SOAP response.
     * @param request
     * @return
     */
    @PayloadRoot(namespace = "http://adammlynarczyk.xyz/exchange", localPart = "getPlnToPoundsRequest")
    @ResponsePayload
    public GetPlnToPoundsResponse getPlnToPounds(@RequestPayload GetPlnToPoundsRequest request){
        logger.info("Got new request for getPlnToPounds. Converting..");
        GetPlnToPoundsResponse res = new GetPlnToPoundsResponse();
        res.setPounds((exchanger.exchangePlnToPound(request.getPln())));
        logger.info("Converted!");
        return res;
    }

    /**
     * Method for pounds to pln exchange. Returns SOAP response.
     * @param request
     * @return
     */
    @PayloadRoot(namespace = "http://adammlynarczyk.xyz/exchange", localPart = "getPoundsToPlnRequest")
    @ResponsePayload
    public GetPoundsToPlnResponse getPoundsToPln(@RequestPayload GetPoundsToPlnRequest request){
        logger.info("Got new request for getPoundsToPln. Converting..");
        GetPoundsToPlnResponse res = new GetPoundsToPlnResponse();
        res.setPln((exchanger.exchangePoundToPln(request.getPounds())));
        logger.info("Converted!");
        return res;
    }

}
