@Component
public class MessageRelProvider implements RelProvider {

    public boolean supports(Class<?> arg0) {
        return SuperClass.class.isAssignableFrom(arg0);
    }

    public String getItemResourceRelFor(Class<?> type) {
        return "superClass";
    }

    public String getCollectionResourceRelFor(Class<?> type) {
        return "superClasses";
    }

}