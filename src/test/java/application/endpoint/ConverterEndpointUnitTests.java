package application.endpoint;

import application.config.BeanConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import xyz.adammlynarczyk.webservice.*;

import static application.converters.ConverterConstans.CENT_METERS;
import static application.converters.ConverterConstans.METERS_INCHES;
import static application.converters.ConverterConstans.MILES_KM;

/**
 * Class tests endpoint and converter itself.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfig.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConverterEndpointUnitTests {
    @Autowired
    ConverterEndpoint endpoint;


    @Test
    public void testCentimetersToMetersEndpoint(){
        GetCentimetersToMetersRequest cmToMetersReq = new GetCentimetersToMetersRequest();
        cmToMetersReq.setCentimeters(1d);
        Assert.assertEquals(1d/CENT_METERS, endpoint.getCentimetersToMeters(cmToMetersReq).getMeters(), 0d);
    }

    @Test
    public void testMetersToCentimetersEndpoint(){
        GetMetersToCentimetersRequest metersToCmReq = new GetMetersToCentimetersRequest();
        metersToCmReq.setMeters(1d);
        Assert.assertEquals(CENT_METERS, endpoint.getMetersToCentimeters(metersToCmReq).getCentimeters(), 0d);
    }

    @Test
    public void testInchesToMeters(){
        GetInchesToMetersRequest inchesToMetReq = new GetInchesToMetersRequest();
        inchesToMetReq.setInches(1d);
        Assert.assertEquals(METERS_INCHES, endpoint.getInchesToMeters(inchesToMetReq).getMeters(), 0d);
    }

    @Test
    public void testMetersToInches(){
        GetMetersToInchesRequest metToInchesReq = new GetMetersToInchesRequest();
        metToInchesReq.setMeters(1d);
        Assert.assertEquals(1/METERS_INCHES, endpoint.getMetersToInches(metToInchesReq).getInches(), 0d);
    }

    @Test
    public void testKilometersToMiles(){
        GetKilometersToMilesRequest kiloToMileReq = new GetKilometersToMilesRequest();
        kiloToMileReq.setKilometers(1d);
        Assert.assertEquals(MILES_KM, endpoint.getKilometersToMiles(kiloToMileReq).getMiles(), 0d);
    }

    @Test
    public void testMilesToKilometers(){
        GetMilesToKilometersRequest milesToKiloReq = new GetMilesToKilometersRequest();
        milesToKiloReq.setMiles(1d);
        Assert.assertEquals(1/MILES_KM, endpoint.getMilesToKilometers(milesToKiloReq).getKilometers(), 0d);
    }



}
