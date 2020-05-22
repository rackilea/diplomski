import java.util.Collection;
import java.util.List;

public class HobbyEditor extends CustomCollectionEditor  {

  @SuppressWarnings("rawtypes")
  public HobbyEditor(Class<? extends Collection> collectionType) {
     super(collectionType);

  }

  @Override
  protected Object convertElement(Object element) {

     if (element instanceof Hobby) {
         return element;
     }
     if (element instanceof String) {
         Hobby  h = new Hobby((String)element);
         return h;
     }
     return null;
  }

}

@InitBinder
protected void initBinder(WebDataBinder binder) {

    binder.registerCustomEditor(List.class, "hobby", new HobbyEditor(List.class));

}