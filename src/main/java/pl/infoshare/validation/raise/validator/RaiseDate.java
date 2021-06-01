package pl.infoshare.validation.raise.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RaiseDateValidator.class)
public @interface RaiseDate {
    String message() default "Invalid raise date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
