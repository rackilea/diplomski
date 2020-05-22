package com.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // must be at least SOURCE
@Target(ElementType.FIELD)
public @interface Foo {}