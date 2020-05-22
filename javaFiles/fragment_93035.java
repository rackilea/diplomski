@ManagedProperty(value="#{param.userId}")
private Long userId;

@PostConstruct
public void init() {
    // Do business stuff based on userId.
}