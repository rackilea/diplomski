public class GenericClass {

    public Object getCast(People p) {
        // In this case the cast to T is removed because T's upper bound is Object.
        // But if T's upper bound was, say, Number, then there would still be a cast
        // to the upper bound. e.g. "(Number)p", and the return type would also be Number
        return p;
    }
}