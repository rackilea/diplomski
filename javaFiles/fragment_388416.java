package com.foo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Service;

import javax.annotation.Priority;
import java.util.List;

interface IService {
    void foo();
}

class LoggerCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return true;
    }
}

class MetricsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return true;
    }
}

@Service
@Qualifier("main")
@Priority(Integer.MAX_VALUE)
class ServiceA implements IService {
    @Override
    public void foo() {
        System.out.println("I'm foo");
    }
}

@Service
@Conditional(LoggerCondition.class)
@Priority(Integer.MAX_VALUE - 1)
class ServiceALogger implements IService {
    private final IService service;

    // using this @Qualifier prevents circular dependency
    public ServiceALogger(@Qualifier("main") IService service) {
        this.service = service;
    }

    @Override
    public void foo() {
        System.out.println("print some logs");
        service.foo();
    }
}

@Service
@Conditional(MetricsCondition.class)
@Priority(Integer.MAX_VALUE - 2)
class ServiceAMetrics implements IService {
    private final IService service;

    public ServiceAMetrics(IService service) {
        this.service = service;
    }

    @Override
    public void foo() {
        System.out.println("send some metrics");
        service.foo();
    }
}

@Configuration
@ComponentScan("com.foo")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Main.class);
        ctx.refresh();

        IService bean = ctx.getBean(IService.class);
        bean.foo();
    }
}