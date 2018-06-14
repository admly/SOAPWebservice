package application.exchange;

import org.springframework.stereotype.Component;

/**
 * Abstract class for modelling converters.
 * @param <T>
 */
@Component
abstract class AbstractExchange<T> {
    abstract T exchangePlnToUsd(T pln);
    abstract T exchangeUsdToPln(T usd);
    abstract T exchangeEuroToPln(T euro);
    abstract T exchangePlnToEuro(T pln);
    abstract T exchangePoundToPln(T pound);
    abstract T exchangePlnToPound(T pln);
}

