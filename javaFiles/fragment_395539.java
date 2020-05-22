public class MyInt {

    [...]

    @Override
    public int hashCode() {
       return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyInt) {
            return i == ((MyInt)obj).i;
        }
        return false;
    }

}