package application.converters;

/**
 * Functional interface for converting lambda
 * @param <T>
 */
@FunctionalInterface
public interface IConverterLambda<T> {
    T convert(T from);
}
