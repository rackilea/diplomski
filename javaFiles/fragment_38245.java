import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;
import org.springframework.validation.beanvalidation.MethodValidationInterceptor;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Method;
import java.util.Set;

class MyMethodValidationInterceptor extends MethodValidationInterceptor {
    private final Validator validator;

    public MyMethodValidationInterceptor() {
        this(Validation.buildDefaultValidatorFactory().getValidator());
    }
    public MyMethodValidationInterceptor(Validator validator) {
        super(validator);
        this.validator = validator;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (isFactoryBeanMetadataMethod(invocation.getMethod())) {
            return invocation.proceed();
        }

        Method methodToValidate = invocation.getMethod();
        Class<?>[] parameterGroups = getArgumentsGroups(methodToValidate);
        if(parameterGroups == null){
            parameterGroups = super.determineValidationGroups(invocation);
        }

        Set<ConstraintViolation<Object>> violations;
        try {
            violations = validator.forExecutables().validateParameters(invocation.getThis(), methodToValidate, invocation.getArguments(), parameterGroups);
        }
        catch (IllegalArgumentException ex) {
            methodToValidate = BridgeMethodResolver.findBridgedMethod(ClassUtils.getMostSpecificMethod(invocation.getMethod(), invocation.getThis().getClass()));
            violations = validator.forExecutables().validateParameters(invocation.getThis(), methodToValidate, invocation.getArguments(), parameterGroups);
        }
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        Object returnValue = invocation.proceed();

        Class<?>[] returnValueGroups = getReturnValueGroups(methodToValidate);
        if(returnValueGroups == null){
            returnValueGroups = super.determineValidationGroups(invocation);
        }

        violations = validator.forExecutables().validateReturnValue(invocation.getThis(), methodToValidate, returnValue, returnValueGroups);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        return returnValue;
    }

    private Class<?>[] getReturnValueGroups(Method methodToValidate){
        ValidateReturnValue annotation =  AnnotationUtils.findAnnotation(methodToValidate, ValidateReturnValue.class);
        if(annotation != null){
            return annotation.value();
        }else {
            return null;
        }
    }

    private Class<?>[] getArgumentsGroups(Method methodToValidate){
        ValidateArguments annotation =  AnnotationUtils.findAnnotation(methodToValidate, ValidateArguments.class);
        if(annotation != null){
            return annotation.value();
        }else {
            return null;
        }
    }

    private boolean isFactoryBeanMetadataMethod(Method method) {
        Class<?> clazz = method.getDeclaringClass();

        if (clazz.isInterface()) {
            return ((clazz == FactoryBean.class || clazz == SmartFactoryBean.class) &&
                    !method.getName().equals("getObject"));
        }

        Class<?> factoryBeanType = null;
        if (SmartFactoryBean.class.isAssignableFrom(clazz)) {
            factoryBeanType = SmartFactoryBean.class;
        }
        else if (FactoryBean.class.isAssignableFrom(clazz)) {
            factoryBeanType = FactoryBean.class;
        }
        return (factoryBeanType != null && !method.getName().equals("getObject") &&
                ClassUtils.hasMethod(factoryBeanType, method));
    }
}