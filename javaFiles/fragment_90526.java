@Root(name = "message")
@XmlRootElement
@Entity
@Table(name="app_messages")
public class MessageBean implements Serializable, DataModel {
....

@PostLoad
public void deleteSensitiveData() {
   this.password = null;
}
}