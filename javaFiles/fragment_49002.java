public class Bar {

    private ObjectGraph objectGraph;

    @Inject
    Bar(ObjectGraph objectGraph){

        this.objectGraph = objectGraph;
    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }
}