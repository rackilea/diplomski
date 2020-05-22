public class Foo<T,I>{

    T val;
    Transformation<List<I>,T> transformation;

    public void setVal(List<I> list>){
        val = transformation.transform(list);
    }
}

public static void main(String[] args){
    Foo<Double,Number> foo = nee Foo(new AveragingTransformer());
    List<Number> nums = new Arraylist<Number>();
    nums.add(2);
    nums.add(3);
    foo.setValue(nums);
}