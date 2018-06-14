package application.exchange;

import static application.exchange.ExchangeConstans.PLN_TO_EURO;
import static application.exchange.ExchangeConstans.PLN_TO_POUND;
import static application.exchange.ExchangeConstans.PLN_TO_USD;

public class Exchange extends AbstractExchange<Double> {

    @Override
    public Double exchangePlnToUsd(Double pln) {
        IExchangeLambda<Double> exchanger = from -> from*PLN_TO_USD;
        return exchanger.exchange(pln);
    }

    @Override
    public Double exchangeUsdToPln(Double usd) {
        IExchangeLambda<Double> exchanger = from -> from/PLN_TO_USD;
        return exchanger.exchange(usd);
    }

    @Override
    public Double exchangeEuroToPln(Double euro) {
        IExchangeLambda<Double> exchanger = from -> from/PLN_TO_EURO;
        return exchanger.exchange(euro);
    }

    @Override
    public Double exchangePlnToEuro(Double pln) {
        IExchangeLambda<Double> exchanger = from -> from*PLN_TO_EURO;
        return exchanger.exchange(pln);
    }

    @Override
    public Double exchangePoundToPln(Double pound) {
        IExchangeLambda<Double> exchanger = from -> from/PLN_TO_POUND;
        return exchanger.exchange(pound);
    }

    @Override
    public Double exchangePlnToPound(Double pln) {
        IExchangeLambda<Double> exchanger = from -> from*PLN_TO_POUND;
        return exchanger.exchange(pln);
    }
}
