@Singleton
public class MetamodelImpl implements Metamodel{
    Map<String, Element> elements;

    @Inject
    public MetamodelImpl(IElement1Factory element1Factory){
        Element element = element1Factory.create("Initialize-Me");
        elements = new HashMap<String, Element>();
        elements.put("Initialize-Me", element);
    }

    public Element getElement(String name){
        return elements.get(name);
    }
}