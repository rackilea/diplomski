public static class Main {

    public static void main(String[] args) {
        Integer[] arr=new Integer[]{1,2,3};
        ArrayList<Object> al=new ArrayList<>();
        Collection<Object> objects = addToCollection(arr, al);  // Compiles
        Collection<Integer> numbers = addToCollection(arr, al); // Doesn't compile
    }

    static <T> Collection<T> addToCollection(T[] a, Collection<T> c)
    {
        for(T o:a) // Behold the side effect
            c.add(o);

        return c;
    }
}