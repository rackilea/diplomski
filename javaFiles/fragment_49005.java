public class EntryPoint {

    public static void main(String[] args){
        FooModule fooModule = new FooModule();
        ObjectGraph objectGraph = ObjectGraph.create(new BarModule(), fooModule);
        fooModule.setObjectGraph(objectGraph);

        System.out.println(objectGraph);

        Bar bar = objectGraph.get(Bar.class);
        ObjectGraph objectGraph1 = bar.getObjectGraph();

        System.out.println(objectGraph);
    }
}