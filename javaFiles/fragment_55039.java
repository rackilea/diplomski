public class Stack {
    private StackNode base;

    public void push(Object item) {
        ...
    }

    // I know this wasn't part of your code
    public Object pop() {
        ...
    }
}

public class TestStack {
    @Test
    public void testOnePush() {
        // GIVEN
        Stack st = new Stack();

        // WHEN
        st.push(new Integer(3)); 
        Object popped = st.pop();

        assertEquals(popped, new Integer(3));
    }
}