@FetchProfiles({
    @FetchProfile(fetchOverrides = { @FetchOverride(association = "c", entity = B.class, mode = FetchMode.JOIN) }, name = "b-with-c")
    })
@Entity
@Table(name="EDITOR_IDENTITIES")
public class B {
    private C c;    
    //...
}