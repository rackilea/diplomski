@Singleton
public class MetamodelImpl implements Metamodel{
    Map<String, Element> elements;

    @Inject
    public MetamodelImpl(Injector injector){
        Element element = new Element1("Initialize-Me");
        injector.injectMembers(element);
        elements = new HashMap<String, Element>();
        elements.put("Initialize-Me", element);
    }

    public Element getElement(String name){
        return elements.get(name);
    }
}

public class Element1 extends Element {
    @Inject
    private ServiceExample serviceExampleImpl;

    private final String property;

    public Element1(String property) {
        this.property = property;
    }
    @Override
    public RestWrapper generateResult(Context context){

        RestWrapper restWrapper = super.generateResult(context);

        // Wanted, by injecting the service, but I can't inject service on element that I create...

        Object object = serviceExampleImpl.getResult(property);
        //do something with object

        return restWrapper;
    }
}