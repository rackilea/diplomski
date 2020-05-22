public class Generic<T> {
    private T valueA;
    private T valueB;
    public boolean matches(Generic<T> that){
        return (this.valueA.equals(that.valueA) &&
                this.valueB.equals(that.valueB));
    }
}