@Component
@Entity
@Table(name="menu")
@Configurable
public class Menu implements Serializable{      
    ....        
    @OneToMany(mappedBy="menu", fetch=FetchType.EAGER)
    private Set<VoceMenu> voceMenus; 

    public Set<VoceMenu> getVoceMenus() {
        return voceMenus;
    }

    public void setVoceMenus(Set<VoceMenu> voceMenus) {
        this.voceMenus = voceMenus;
    }

    //bind to this
    public List<VoceMenu> getVoceMenusAsList(){
        return new ArrayList<VoceMenu>(voceMenus);
    }
    .....   
}