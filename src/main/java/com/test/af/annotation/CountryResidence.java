package com.test.af.annotation;


import com.test.af.Validator.CountryResidenceValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <pre>
 * @author Adib LEZZAR
 * This class is used to create a custom annotation check if user live in France
 * </pre>
 */
@Constraint(validatedBy = CountryResidenceValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface CountryResidence {

    /**
     * @return default message of the annotation
     */
    String message() default "{com.test.af.annotation.CountryResidence.message}";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
