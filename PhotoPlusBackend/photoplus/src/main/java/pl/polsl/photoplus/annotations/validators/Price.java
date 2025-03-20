package pl.polsl.photoplus.annotations.validators;

import pl.polsl.photoplus.validators.PriceValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PriceValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Price {
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Bad price.";
}