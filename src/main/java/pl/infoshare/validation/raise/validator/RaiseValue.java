package pl.infoshare.validation.raise.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RaiseValueValidator.class)
public @interface RaiseValue {
    int maxRaiseInPercentage();

    String message() default "Invalid raise value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
