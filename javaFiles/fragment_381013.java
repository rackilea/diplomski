@FetchProfiles({
    @FetchProfile(fetchOverrides = { @FetchOverride(association = "b", entity = A.class, mode = FetchMode.JOIN) }, name = "a-with-b")
    })
@Entity
@Table(name="EDITOR_IDENTITIES")
public class A {
    private B b;    
    //...
}