//building query
for each field
  Class fieldClass = findFieldClas(.., field) //use reflection or map
  PathHandler handler = handlers.get(fieldClass)
  handler.process( ...)

//type handler interface
public interface Handler{
  public xx process(? extends DataPathBase);
}

//specific type handler implementation
public class BooleanHandler implements Handler{
  public xx process(? extends DataPathBase path){
    BooleanPath bPath = (BooleanPath)path;
    ...
}

//intitialize handlers map singleton or a factory in advance    
handlers.put(BooleanPath.class, new BooleanHandler());
...