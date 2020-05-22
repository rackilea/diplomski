import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import org.junit.Assert;

public class NonEmptyObservableListTest {

    @Test (expected = IllegalStateException.class)
    public void testExceptionFromListChangeListener() {
        NonEmptyObservableList<String> list = new NonEmptyObservableList<>(new ArrayList<>(Arrays.asList("one", "two")));
        list.clear();
    }


    @Test
    public void testSizeOnClear() {
        NonEmptyObservableList<String> list = new NonEmptyObservableList<>(new ArrayList<>(Arrays.asList("one", "two")));
        try {
            list.clear();
        } catch (Exception e) {
            // squash exception to test list size...
        }
        Assert.assertSame("List size is not 1", list.size(), 1);
    }
}