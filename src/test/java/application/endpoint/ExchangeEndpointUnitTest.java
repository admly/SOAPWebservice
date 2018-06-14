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
import xyz.adammlynarczyk.exchange.*;

import static application.exchange.ExchangeConstans.PLN_TO_EURO;
import static application.exchange.ExchangeConstans.PLN_TO_POUND;
import static application.exchange.ExchangeConstans.PLN_TO_USD;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfig.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExchangeEndpointUnitTest {
    @Autowired
     ExchangeEndpoint endpoint;


    @Test
    public void testPlnToUsdEndpoint(){
        GetPlnToUsdRequest plnToUsdReq = new GetPlnToUsdRequest();
        plnToUsdReq.setPln(1d);
        Assert.assertEquals(PLN_TO_USD, endpoint.getPlnToUsd(plnToUsdReq).getUsd(), 0d);
    }

    @Test
    public void testUsdToPlnEndpoint(){
        GetUsdToPlnRequest usdToPlnReq = new GetUsdToPlnRequest();
        usdToPlnReq.setUsd(1d);
        Assert.assertEquals(1/PLN_TO_USD, endpoint.getUsdToPln(usdToPlnReq).getPln(), 0d);
    }

    @Test
    public void testPlnToPoundsEndpoint(){
        GetPlnToPoundsRequest plnToPoundsReq = new GetPlnToPoundsRequest();
        plnToPoundsReq.setPln(1d);
        Assert.assertEquals(PLN_TO_POUND, endpoint.getPlnToPounds(plnToPoundsReq).getPounds(), 0d);
    }

    @Test
    public void testPoundsToPlnEndpoint(){
        GetPoundsToPlnRequest poundsToPlnReq = new GetPoundsToPlnRequest();
        poundsToPlnReq.setPounds(1d);
        Assert.assertEquals(1/PLN_TO_POUND, endpoint.getPoundsToPln(poundsToPlnReq).getPln(), 0d);
    }

    @Test
    public void testPlnToEuroEndpoint(){
        GetPlnToEuroRequest plnToEuroReq = new GetPlnToEuroRequest();
        plnToEuroReq.setPln(1d);
        Assert.assertEquals(PLN_TO_EURO, endpoint.getPlnToEuro(plnToEuroReq).getEuro(), 0d);
    }

    @Test
    public void testEuroToPlnEndpoint(){
        GetEuroToPlnRequest euroToPlnReq = new GetEuroToPlnRequest();
        euroToPlnReq.setEuro(1d);
        Assert.assertEquals(1/PLN_TO_EURO, endpoint.getEuroToPln(euroToPlnReq).getPln(), 0d);
    }



}
