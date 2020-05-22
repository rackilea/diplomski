@Named
@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class SessionController {

private HashMap<String, UserSession> sessionMap;

@PostConstruct
void init() {
    sessionMap = new HashMap<String, UserSession>();
}

@PreDestroy
void terminate() {
    for (UserSession us : sessionMap.values()) {
        us.logoutCleanUp(); //This is annotated as @Remove
    }
    sessionMap.clear();
}

public void addSession(String sessionId, UserSession us) {
    sessionMap.put(sessionId, us);
    System.out.println("New Session added: " + sessionId);
}

public UserSession getCurrentUserSession() {
    FacesContext context = FacesContext.getCurrentInstance();
    String sessionId = ((HttpSession) context.getExternalContext().getSession(false)).getId();
    return sessionMap.get(sessionId);
}