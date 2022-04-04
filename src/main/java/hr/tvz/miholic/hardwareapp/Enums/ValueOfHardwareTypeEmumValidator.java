package hr.tvz.miholic.hardwareapp.Enums;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValueOfHardwareTypeEmumValidator implements ConstraintValidator<ValueOfHardwareTypeEnum, CharSequence> {
    private List<String> acceptedValues;
    @Override
    public void initialize(ValueOfHardwareTypeEnum annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        if (charSequence == null) {
            return true;
        }

        return acceptedValues.contains(charSequence.toString());
    }
}
