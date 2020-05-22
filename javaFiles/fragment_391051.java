import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClass {


    Object object1 = new Object();
    Object object2 = new Object();

    class Thing{
        public Object thingFunction(){
            return null;
        }
    }

    @Test
    public void test(){
        Thing thing = Mockito.mock(Thing.class);
        Mockito.doAnswer(new Answer<Object>() {
              int counter = 0;

              @Override
              public Object answer(InvocationOnMock invocation) throws Throwable {
                if (counter == 0) {
                    counter += 1;
                  return object1;
                } else {
                  return object2;
                }
              }
            }).when(thing).thingFunction();

        assertEquals(object1, thing.thingFunction());
        assertEquals(object2, thing.thingFunction());
    }
}