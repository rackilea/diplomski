import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class MyItem {
    @Id public Long id;
    @Parent private Ref<MyCategory> parent;

    @Index private Ref<MyCategory> myCategory; public static final String MyCategoryField = "myCategory";   
    @Index public Long index; public static final String IndexField = "index"; 

    public String label;
    public long weight;

    public MyCategory getGroup() {
        return group.get();
    }

    public void setGroup(MyCategory group) {
        this.group = Ref.create(group);
    }

    public MyCategory getParent() {
        return parent.get();
    }

    public void setParent(MyCategory group) {
        this.parent = Ref.create(group);
    }
}