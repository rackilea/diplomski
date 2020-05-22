public class StartLink<T extends Comparable<T>> implements AbstractLink<T> {

    final AbstractLink<T>[] nexts;

    public StartLink(int n){
        this.nexts = (AbstractLink<T>[]) new Object[n];
    }
}