package org.junit.runners;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.annotation.RunWithInEnvironment;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class EnvironmentDependentRunner extends Runner {
    protected Class<?> testClass;
    protected Runner delegate;

    public EnvironmentDependentRunner(Class<?> testClass) {
        super();
        this.testClass = testClass;
        RunWithInEnvironment annotation = findAnnotationInClassHierarchy(testClass);
        assertNotNull( EnvironmentDependentRunner.class.getSimpleName() + " can be used only with test classes, that are annotated with " + RunWithInEnvironment.class.getSimpleName() + " annotation somewhere in their class hierarchy!", annotation );
        Class<? extends Runner> delegateClass = null;
        if ( System.getProperty( "sun.java.command" ).contains( "org.eclipse.jdt" ) && annotation.eclipse() != null ) {
            delegateClass = annotation.eclipse();
        }
        else {
            delegateClass = annotation.defaultRunner();
        }
        try {
            Constructor<? extends Runner> constructor = delegateClass.getConstructor( Class.class );
            delegate = constructor.newInstance(testClass);
        } catch (NoSuchMethodException e) {
            fail( delegateClass.getName() + " must contain a public constructor with a " + Class.class.getName() + " argument.");
        } catch (SecurityException e) {
            throw new RuntimeException("SecurityException during instantiation of " + delegateClass.getName() );
        } catch (InstantiationException e) {
            throw new RuntimeException("Error while creating " + delegateClass.getName() );
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error while creating " + delegateClass.getName() );
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error while creating " + delegateClass.getName() );
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Error while creating " + delegateClass.getName() );
        }
    }

    private RunWithInEnvironment findAnnotationInClassHierarchy(Class<?> testClass) {
        RunWithInEnvironment annotation = testClass.getAnnotation(RunWithInEnvironment.class);
        if (annotation != null) {
            return annotation;
        }

        Class<?> superClass = testClass.getSuperclass();
        if (superClass != null) {
            return findAnnotationInClassHierarchy(superClass);
        }

        return null;
    }

    @Override
    public Description getDescription() {
        return delegate.getDescription();
    }

    @Override
    public void run(RunNotifier arg0) {
        delegate.run(arg0);
    }
}