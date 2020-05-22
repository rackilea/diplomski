@Entity
@Table (name ="appinfo")
public class AppInfo implements Serializable {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="preferenceid", referencedColumnName="preferencesid")
    private Preferences p;