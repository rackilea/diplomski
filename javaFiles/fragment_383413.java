public class MyAttributeListener implements HttpSessionAttributeListener {

@Override
public void attributeAdded(HttpSessionBindingEvent event) {
    String attributeName = event.getName();
    Object attributeValue = event.getValue();
    System.out.println("Attribute added : " + attributeName + " : " + attributeValue);
}

@Override
public void attributeRemoved(HttpSessionBindingEvent event) {
    String attributeName = event.getName();
    Object attributeValue = event.getValue();
    System.out.println("Attribute removed : " + attributeName + " : " + attributeValue);
}

@Override
public void attributeReplaced(HttpSessionBindingEvent event) {
    String attributeName = event.getName();
    Object attributeValue = event.getValue();
    System.out.println("Attribute replaced : " + attributeName + " : " + attributeValue);   
}