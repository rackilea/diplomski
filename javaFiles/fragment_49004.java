@Module(
        includes = BarModule.class,
        injects = ObjectGraph.class,
        complete = true,
        library = true
)
public class FooModule {

    private ObjectGraph objectGraph;

    public void setObjectGraph(ObjectGraph objectGraph){

        this.objectGraph = objectGraph;
    }

    @Provides @Singleton ObjectGraph providesObjectGraph(){
        return null;
    }
}