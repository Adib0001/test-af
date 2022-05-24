package com.test.af.Validator;

import com.test.af.annotation.BirthDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

/**
 * <pre>
 * @author Adib LEZZAR
 * This class implement custom birth date validator
 * </pre>
 */
public class BirthDateValidator implements ConstraintValidator<BirthDate, LocalDate> {

    /**
     * Checks if user has age greater than 18
     * @param birthDateToValidate The user birth date
     * @param context Defines the context when applying the annotation
     * @return A boolean true if age greater than or equal to 18, false otherwise
     */
    @Override
    public boolean isValid(final LocalDate birthDateToValidate, final ConstraintValidatorContext context) {

        Period periode = Period.between(birthDateToValidate,LocalDate.now());

        return periode.getYears() >= 18;
    }
}
