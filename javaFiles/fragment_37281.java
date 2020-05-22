@ManagedBean
@RequestScoped
public class AnotherPageBean {

    private int id;
    /**
    * Creates a new instance of AnotherPageBean
    */
    public AnotherPageBean() {
        try {
            this.id = Integer.parseInt((String)FacesContext
               .getCurrentInstance().getExternalContext()
               .getRequestParameterMap().get("id"));
            //by getting the id you can get more data
        }
        catch (Exception e) {
            this.id = 0;
        }
    }