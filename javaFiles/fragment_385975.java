public class CommonFolder<T, U> implements FolderMaster<T, U>{
    public U foldIt(U u, Queue<T> ts, FunctionBi<T, U, U> bidi){
        if(u == null || ts == null || bidi == null)
            throw new IllegalArgumentException();

        while (!ts.isEmpty()) {
            u = bidi.applyIt(ts.poll(), u);
        }

        return u;
    }
}