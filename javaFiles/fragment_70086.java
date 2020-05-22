package com.perfectcomputersolutions.pos.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.reflect.CodeSignature
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Order(0)
@Component
class NoNullArgsAspect {

    // Use this if writing in Java.
    // omitting the getMetaClass call is only for Groovy

    // @Before(
    //         value = "@within(com.perfectcomputersolutions.pos.annotation.NoNullArgs) || @annotation(com.perfectcomputersolutions.pos.annotation.NoNullArgs)"
    // )

    @Before(
            value = "!execution(* *.getMetaClass(..)) && @within(com.perfectcomputersolutions.pos.annotation.NoNullArgs) || @annotation(com.perfectcomputersolutions.pos.annotation.NoNullArgs)"
    )
    void requireNotNull(JoinPoint jp) {

        def method = (CodeSignature) jp.signature
        def types  = method.parameterTypes
        def names  = method.parameterNames
        def args   = jp.args

        for (int i = 0; i < types.length; i++)
            Objects.requireNonNull(args[i], "Parameter ${names[i]} must not be null" as String)
    }
}