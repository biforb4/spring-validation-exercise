package pl.infoshare.validation.raise.validator;

import pl.infoshare.validation.raise.model.RaiseRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class RaiseValueValidator implements ConstraintValidator<RaiseValue, RaiseRequest> {
    private BigDecimal maxRaiseInPercentage;
    @Override
    public void initialize(RaiseValue constraintAnnotation) {
        this.maxRaiseInPercentage = new BigDecimal(constraintAnnotation.maxRaiseInPercentage());
    }

    @Override
    public boolean isValid(RaiseRequest value, ConstraintValidatorContext context) {
        if(Objects.isNull(value.getCurrentSalary()) || Objects.isNull(value.getProposedSalary())) {
            return false;
        }

        var percentage = value.getProposedSalary()
                .divide(value.getCurrentSalary(), 2,  RoundingMode.HALF_DOWN)
                .multiply(new BigDecimal(100))
                .subtract(new BigDecimal(100));

        return percentage.compareTo(maxRaiseInPercentage) <= 0;
    }
}
