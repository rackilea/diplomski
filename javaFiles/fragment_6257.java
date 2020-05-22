public class UserSession implements Serializable {
@Inject SessionController sc;
...
    @PostConstruct
    void init() {
    FacesContext context = FacesContext.getCurrentInstance();
    String sessionId = ((HttpSession) context.getExternalContext().getSession(true)).getId();
    sc.addSession(sessionId, this);
}