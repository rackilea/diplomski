public class Foo {
    String field1, field2;
    List<Foo> array1;

    public static void traverse(Foo f) {
        if (f.array1 == null) return;
        // do something for current object 
        for (Foo next : f.array1) traverse(next);
        // do something after visiting all children 
   } 
}