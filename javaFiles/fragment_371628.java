package org.stackoverflow.helizone.test;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonArrayMember {
    public String value();
}