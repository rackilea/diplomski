@Entity
@Table(name="sdkmaincollection")
public class SDKMainCollection {

...
...
@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
private List<Sdkcollection> sdkCollection = new ArrayList<Sdkcollection>();

//No Constructor required
//Kept only getters and setters
}