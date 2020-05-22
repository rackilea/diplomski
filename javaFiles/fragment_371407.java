package de.scrum_master.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.SoftException;
import org.aspectj.lang.reflect.MethodSignature;

import de.scrum_master.app.MyAnnotation;

public aspect AnnotationParameterAspect {
    pointcut methodExecutionInAnnotatedClass(MyAnnotation myAnnotation) :
        @within(myAnnotation) && execution(* *(..));

    pointcut annotatedMemberReadAccess(MyAnnotation myAnnotation) :
        @annotation(myAnnotation) && get(* *);

    pointcut annotatedMemberWriteAccess(MyAnnotation myAnnotation) :
        @annotation(myAnnotation) && set(* *);

    pointcut annotatedMethodExecution(MyAnnotation myAnnotation) :
        @annotation(myAnnotation) && execution(* *(..));

    pointcut annotatedMethodParameter() :
        execution(* *(.., @MyAnnotation (*), ..));

    after(MyAnnotation myAnnotation) returning(Object returnValue) :
        methodExecutionInAnnotatedClass(myAnnotation)
    {
        System.out.println(thisJoinPoint + " -> " + returnValue);
        printAnnotation(myAnnotation);
    }

    after(MyAnnotation myAnnotation) returning(Object returnValue) :
        annotatedMemberReadAccess(myAnnotation)
    {
        System.out.println(thisJoinPoint + " -> " + returnValue);
        printAnnotation(myAnnotation);
    }

    after(MyAnnotation myAnnotation, Object newValue) :
        annotatedMemberWriteAccess(myAnnotation) && args(newValue)
    {
        System.out.println(thisJoinPoint + " -> " + newValue);
        printAnnotation(myAnnotation);
    }

    after(MyAnnotation myAnnotation) returning(Object returnValue) :
        annotatedMethodExecution(myAnnotation)
    {
        System.out.println(thisJoinPoint + " -> " + returnValue);
        printAnnotation(myAnnotation);
    }

    after() : annotatedMethodParameter() {
        System.out.println(thisJoinPoint);
        MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
        Class<?> clazz = methodSignature.getDeclaringType();
        try {
            Method method = clazz.getDeclaredMethod(methodSignature.getName(), methodSignature.getParameterTypes());
            for (Annotation[] parameterAnnotations : method.getParameterAnnotations()) {
                for (Annotation annotation : parameterAnnotations) {
                    if (annotation instanceof MyAnnotation)
                        printAnnotation((MyAnnotation) annotation);
                }
            }
        }
        catch (NoSuchMethodException nsme) {
            throw new SoftException(nsme);
        }
    }

    private static void printAnnotation(MyAnnotation myAnnotation) {
        System.out.println("  " + myAnnotation);
        System.out.println("    id   = " + myAnnotation.id());
        System.out.println("    name = " + myAnnotation.name() + "\n");
    }
}