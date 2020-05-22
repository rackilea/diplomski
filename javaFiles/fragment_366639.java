import java.util.*;
class myStackReverse<E> extends Stack<E> {
    public String toStringReverse() {
        Stack<E> origStack = (Stack)this.clone();
        Stack<E> revStack = new Stack<E>();
        while (!origStack.isEmpty()) {
            revStack.add(origStack.pop());
        }
        return revStack.toString();
    }
}