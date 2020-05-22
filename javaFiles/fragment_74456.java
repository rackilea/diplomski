public class Generic<T extends Comparable<? super T>> {
    private T valueA;
    private T valueB;
    public boolean matches(Generic<T> that){
        return (this.valueA.compareTo(that.valueA) == 0 &&
                this.valueB.compareTo(that.valueB) == 0);
    }
}