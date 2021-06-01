package pl.infoshare.validation.raise.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class RaiseDateValidator implements ConstraintValidator<RaiseDate, LocalDate> {

    @Override
    public void initialize(RaiseDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        var now = LocalDate.now();
        var max = LocalDate.now().plusMonths(3);

        return value.isAfter(now) && value.isBefore(max);
    }
}
