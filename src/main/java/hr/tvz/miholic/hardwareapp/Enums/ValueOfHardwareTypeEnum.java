package hr.tvz.miholic.hardwareapp.Enums;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static hr.tvz.miholic.hardwareapp.Enums.HardwareTypeEnum.printAll;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValueOfHardwareTypeEmumValidator.class)
public @interface ValueOfHardwareTypeEnum {



    Class<? extends Enum<?>> enumClass();
    /*
    String message() default "must be any of enum {enumClass}";
     */
    String message() default "Type is not valid!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
