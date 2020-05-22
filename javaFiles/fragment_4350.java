public class DataTableEntity {
    List<Objects> objectContainer;

    // The Objects know already which Class they are, no need to pass it
    public void setLinks() {
        for(Object obj : objectContainer) {
            if(obj instanceof ClassA) {
                ClassA a = (ClassA)obj;
                a.doSomething();
            }
            else if(obj instanceof ClassB) {
                ClassB b = (ClassB)obj;
                b.doSomethingElse();
            }
            // and so on ...
        }
    }
}