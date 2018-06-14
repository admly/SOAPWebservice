package application.converters;

import org.springframework.stereotype.Component;

/**
 * Abstract class for modelling converters.
 * @param <T>
 */
@Component
abstract class AbstractConverter<T> {
    abstract T convertKilometersToMiles(T kilometers);
    abstract T convertMilesToKilometers(T miles);
    abstract T convertMetersToInches(T meters);
    abstract T convertInchesToMeters(T inches);
    abstract T convertCentimetersToMeters(T centimeters);
    abstract T convertMetersToCentimeters(T meters);
}

