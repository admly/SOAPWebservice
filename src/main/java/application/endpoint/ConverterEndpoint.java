package application.endpoint;

import application.converters.Converter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xyz.adammlynarczyk.webservice.*;


/**
 * Endpoint for unit conversion.
 */
@Endpoint
public class ConverterEndpoint {

    private Converter converter;

    @Autowired
    public ConverterEndpoint(Converter converter){
        this.converter = converter;
    }

    Logger logger = LogManager.getLogger(ConverterEndpoint.class);

    /**
     * Method for centimeters to meters conversion. Returns SOAP response.
     * @param request
     * @return
     */
    @PayloadRoot(namespace = "http://adammlynarczyk.xyz/webservice", localPart = "getCentimetersToMetersRequest")
    @ResponsePayload
    public GetCentimetersToMetersResponse getCentimetersToMeters(@RequestPayload GetCentimetersToMetersRequest request){
        logger.info("Got new request for getCentimetersToMeters. Converting..");
        GetCentimetersToMetersResponse res = new GetCentimetersToMetersResponse();
        res.setMeters((converter.convertCentimetersToMeters(request.getCentimeters())));
        logger.info("Converted!");
        return res;
    }

    /**
     * Method for meters to centimeters conversion. Returns SOAP response.
     * @param request
     * @return
     */
    @PayloadRoot(namespace = "http://adammlynarczyk.xyz/webservice", localPart = "getMetersToCentimetersRequest")
    @ResponsePayload
    public GetMetersToCentimetersResponse getMetersToCentimeters(@RequestPayload GetMetersToCentimetersRequest request){
        logger.info("Got new request for getMetersToCentimeters. Converting..");
        GetMetersToCentimetersResponse res = new GetMetersToCentimetersResponse();
        res.setCentimeters((converter.convertMetersToCentimeters(request.getMeters())));
        logger.info("Converted!");
        return res;
    }

    /**
     * Method for kilometers to miles conversion. Returns SOAP response.
     * @param request
     * @return
     */
    @PayloadRoot(namespace = "http://adammlynarczyk.xyz/webservice", localPart = "getKilometersToMilesRequest")
    @ResponsePayload
    public GetKilometersToMilesResponse getKilometersToMiles(@RequestPayload GetKilometersToMilesRequest request){
        logger.info("Got new request for getKilometersToMiles. Converting..");
        GetKilometersToMilesResponse res = new GetKilometersToMilesResponse();
        res.setMiles((converter.convertKilometersToMiles(request.getKilometers())));
        logger.info("Converted!");
        return res;
    }

    /**
     * Method for miles to kilometers conversion. Returns SOAP response.
     * @param request
     * @return
     */
    @PayloadRoot(namespace = "http://adammlynarczyk.xyz/webservice", localPart = "getMilesToKilometersRequest")
    @ResponsePayload
    public GetMilesToKilometersResponse getMilesToKilometers(@RequestPayload GetMilesToKilometersRequest request){
        logger.info("Got new request for getMilesToKilometers. Converting..");
        GetMilesToKilometersResponse res = new GetMilesToKilometersResponse();
        res.setKilometers((converter.convertMilesToKilometers(request.getMiles())));
        logger.info("Converted!");
        return res;
    }

    /**
     * Method for meters to inches conversion. Returns SOAP response.
     * @param request
     * @return
     */
    @PayloadRoot(namespace = "http://adammlynarczyk.xyz/webservice", localPart = "getMetersToInchesRequest")
    @ResponsePayload
    public GetMetersToInchesResponse getMetersToInches(@RequestPayload GetMetersToInchesRequest request){
        logger.info("Got new request for getMetersToInches. Converting..");
        GetMetersToInchesResponse res = new GetMetersToInchesResponse();
        res.setInches((converter.convertMetersToInches(request.getMeters())));
        logger.info("Converted!");
        return res;
    }

    /**
     * Method for inches to meters conversion. Returns SOAP response.
     * @param request
     * @return
     */
    @PayloadRoot(namespace = "http://adammlynarczyk.xyz/webservice", localPart = "getInchesToMetersRequest")
    @ResponsePayload
    public GetInchesToMetersResponse getInchesToMeters(@RequestPayload GetInchesToMetersRequest request){
        logger.info("Got new request for getInchesToMeters. Converting..");
        GetInchesToMetersResponse res = new GetInchesToMetersResponse();
        res.setMeters((converter.convertInchesToMeters(request.getInches())));
        logger.info("Converted!");
        return res;
    }

}
