package org.junit.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.runner.Runner;
import org.junit.runners.JUnit4;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target( ElementType.TYPE )
public @interface RunWithInEnvironment {
    Class<? extends Runner> eclipse();
    Class<? extends Runner> defaultRunner() default JUnit4.class;
}