package application.exchange;

/**
 * Functional interface for exchanging lambda
 * @param <T>
 */
@FunctionalInterface
public interface IExchangeLambda<T> {
    T exchange(T from);
}
