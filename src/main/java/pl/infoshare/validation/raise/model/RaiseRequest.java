package pl.infoshare.validation.raise.model;

import lombok.Value;
import pl.infoshare.validation.raise.validator.RaiseDate;
import pl.infoshare.validation.raise.validator.RaiseValue;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Value
@RaiseValue(maxRaiseInPercentage = 30)
public class RaiseRequest {
    @NotNull
    BigDecimal currentSalary;
    @RaiseDate
    LocalDate proposedRaiseDate;
    @NotNull
    BigDecimal proposedSalary;
    @Size(max = 2)
    @NotNull
    @Valid
    List<AcceptedRaise> previousRaises;
}
