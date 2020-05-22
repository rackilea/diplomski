@ManagedBean
@RequestScoped
public class Country {

    @EJB
    private CommomBeanRemote commonBeanRemote;
    private Collection<entity.Country> countries;

    @PostConstruct
    public void init() {
        countries = commonBeanRemote.getAllCountries();
    }

    public Collection<entity.Country> getCountries() {
        return countries;
    }

    // Setter is completely unnecessary here.
}