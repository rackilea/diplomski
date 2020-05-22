import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

class Person {    
    @Presentable({
        @Restriction(type = RestrictionType.LENGTH, value = 5),
        @Restriction(type = RestrictionType.FRACTION_DIGIT, value = 2)
    })
    public String name;
}

enum RestrictionType {
    NONE, LENGTH, FRACTION_DIGIT;
}

@Retention(RetentionPolicy.RUNTIME)
@interface Restriction {
    //The below fixes the compile error by changing type from String to RestrictionType
    RestrictionType type() default RestrictionType.NONE;
    int value() default 0;
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@interface Presentable {
  Restriction[] value();
}