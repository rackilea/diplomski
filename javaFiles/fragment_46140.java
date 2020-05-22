@ManagedBean(name = "mrBean")
@ViewScoped
public class MrBean {
   private String id;

   @PostConstruct
   public void prepareReview() {
       HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
       id = request.getParameter("id");
   }
}