@Named
@RequestScoped
public class Resources {
       @Produces
       public FacesContext produceFacesContext() {
              return FacesContext.getCurrentInstance();
       }
}