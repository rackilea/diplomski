package de.scrum_master.aspectj;

public abstract aspect AbstractAspect {
    protected abstract pointcut publicMethod();

    Object around() : publicMethod() {
        System.out.println(thisJoinPointStaticPart);
        return proceed();
    }
}