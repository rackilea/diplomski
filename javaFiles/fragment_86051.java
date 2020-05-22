public static interface MyInterface extends Comparable<MyInterface> {

}

public static class MyClass implements MyInterface {

    @Override
    public int compareTo(MyInterface another) {
        return 0; //write a comparison method here
    }
}