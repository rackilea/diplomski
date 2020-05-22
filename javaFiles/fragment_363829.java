@Entity
@Table (name ="appinfo")
public class AppInfo implements Serializable {
    ....
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="preferenceid")
    private Preferences p;



@Entity
@Table (name ="preferences")
public class Preferences implements Serializable {
    ....
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="appuserid")
    private AppInfo ai;