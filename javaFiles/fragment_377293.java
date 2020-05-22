@Entity
@Table(name="sdkcollection")
public class SDKCollection {

...
...
@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
private List<Ads> ads = new ArrayList<Ads>();

//No parent table with @ManyToOne was refered
//No Constructor required
//Kept only getters and setters

}