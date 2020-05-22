@ManagedBean
@SessionScoped
private OtherBean {

    @ManagedProperty(value="#{userSession}")
    private UserSession userSession;

    private String token;

    @PostConstruct
    public void init() { 
        this.token = userSession.getToken();
    }

    public void someAction() {
        doSomethingWith(token);
    }

    public void otherAction() {
        doSomethingElseWith(token);
    }

    // ...
}