package application.converters;

import static application.converters.ConverterConstans.*;

/**
 * Class responsible for converting units. Converting function is a lambda.
 */
public class Converter extends AbstractConverter<Double> {


    /**
     *  Method for converting from kilometers to miles
     * @param kilometers
     * @return
     */
    @Override
    public Double convertKilometersToMiles(Double kilometers) {
        IConverterLambda<Double> converter = from -> from* MILES_KM;
        return converter.convert(kilometers);
    }

    /**
     *  Method for converting from miles to kilometers
     * @param miles
     * @return
     */
    @Override
    public Double convertMilesToKilometers(Double miles) {
        IConverterLambda<Double> converter = from -> from/MILES_KM;
        return converter.convert(miles);
    }

    /**
     *  Method for converting from meters to inches
     * @param meters
     * @return
     */
    @Override
    public Double convertMetersToInches(Double meters) {
        IConverterLambda<Double> converter = from -> from/METERS_INCHES;
        return converter.convert(meters);
    }

    /**
     *  Method for converting from inches to meters
     * @param inches
     * @return
     */
    @Override
    public Double convertInchesToMeters(Double inches) {
        IConverterLambda<Double> converter = from -> from*METERS_INCHES;
        return converter.convert(inches);
    }

    /**
     *  Method for converting from centimeters to meters
     * @param centimeters
     * @return
     */
    @Override
    public Double convertCentimetersToMeters(Double centimeters) {
        IConverterLambda<Double> converter = from -> from/CENT_METERS;
        return converter.convert(centimeters);
    }

    /**
     *  Method for converting from meters to centimeters
     * @param meters
     * @return
     */
    @Override
    public Double convertMetersToCentimeters(Double meters) {
        IConverterLambda<Double> converter = from -> from*CENT_METERS;
        return converter.convert(meters);
    }
}
