public class Test { 
    public static void main(String[] args) {
        List<MyClass> list = new ArrayList<>();
        for(int i = 0; i < 15; i++){
            list.add(new MyClass(i, String.valueOf(i)));
        }
        System.out.println(getSubList(list, o -> o.s.startsWith("10"))); //[MyClass [a=10, b=10], MyClass [a=11, b=11], MyClass [a=12, b=12], MyClass [a=13, b=13], MyClass [a=14, b=14]]

    }
    static <T> List<T> getSubList(List<T> list, Predicate<T> pred){
        return list.subList(list.indexOf(list.stream().filter(pred).findFirst().get()), list.size());
    }
}
class MyClass {
    int i;
    String s;
    public MyClass(int i,String s){
        this.i = i;
        this.s = s;
    }
    @Override
    public String toString() {
        return "MyClass [i=" + i + ", s=" + s + "]";
    }

}