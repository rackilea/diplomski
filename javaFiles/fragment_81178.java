public class MyClass<T extends Comparable<T>>{

    private List<T> input;

    public MyClass(List<T> input){
        this.input = input;
    }

}