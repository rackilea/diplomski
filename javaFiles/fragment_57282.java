import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.matchers.VarargMatcher;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestVarArgMatcher {

    @Test
    public void testAnyVarArg() {
        Collaborator c = mock(Collaborator.class);
        when(c.f(any())).thenReturn(6);
        assertEquals(6, c.f("a", "b", "c")); // passes
    }

    @Test
    public void testVarArg() {
        Collaborator c = mock(Collaborator.class);

        ArrayElementMatcher<String> matcher = new ArrayElementMatcher<>("b");
        when(c.f(argThat(matcher))).thenAnswer(invocationOnMock -> matcher.isElementFound() ? 7 : 0);

        assertEquals(7, c.f("a", "b", "c")); 
    }


    interface Collaborator {
        int f(String... args);
    }

    private static class ArrayElementMatcher<T> implements ArgumentMatcher<T>, VarargMatcher {
        private final T element;
        private boolean elementFound = false;

        public ArrayElementMatcher(T element) {
            this.element = element;
        }

        public boolean isElementFound() {
            return elementFound;
        }

        @Override
        public boolean matches(T t) {
            elementFound |= element.equals(t);
            return true;
        }
    }
}