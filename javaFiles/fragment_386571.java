class Parent<T> {
    protected T results;

    public T getResults() {
        return results;
    } 
}

class Child extends Parent<HashMap<String, Integer>> {

    public void operation() { 
        HashMap<String, Integer> map = getResults();
        ...
    }
}