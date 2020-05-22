import static com.googlecode.objectify.ObjectifyService.begin;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.util.Closeable;

public class Repository {
    public Topic createMyCategory() {
        Topic entity = topicProvider.get();
        updateTopic(entity);
        return entity;
    }   

    public MyItem lookupMyItem(MyCategory myCategory, long i) {
        return ofy().load().type(MyItem.class).ancestor(myCategory).filter(MyItem.MyCategoryField, myCategory).filter(MyItem.IndexField, i).first().now();
    }
}