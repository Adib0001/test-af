package com.test.af.Validator;

import com.test.af.annotation.CountryResidence;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * <pre>
 * @author Adib LEZZAR
 * This class implement custom country residence validator
 * </pre>
 */
public class CountryResidenceValidator implements ConstraintValidator<CountryResidence,String> {

    /**
     * Checks if user live in France
     * @param address The user address
     * @param context Defines the context when applying the annotation
     * @return A boolean true if the user lives in France, false otherwise
     */
    @Override
    public boolean isValid(final String address, final ConstraintValidatorContext context) {
        return address.toLowerCase().contains("france");
    }
}
