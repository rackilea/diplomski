import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Method;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyTest {
    AccountService accountService;

    @Test
    public void testMyMethod() {
        accountService = new AccountService();

        ProceedingJoinPoint joinPoint = mock(ProceedingJoinPoint.class);
        MethodSignature signature = mock(MethodSignature.class);

        when(joinPoint.getTarget()).thenReturn(accountService);
        when(joinPoint.getSignature()).thenReturn(signature);
        when(signature.getMethod()).thenReturn(myMethod());
        //work with 'someMethod'...
    }

    public Method myMethod() {
        return getClass().getDeclaredMethod("someMethod");
    }

    public void someMethod() {
        //customize me to have these:
        //1. The parameters you want for your test
        //2. The return type you want for your test
        //3. The annotations you want for your test
    }
}