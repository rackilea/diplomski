// NO @Autowired here
private Services services;

@Autowired // this is actually optional unless you have another constructor
public ContactView(Services services) {
    this.services = services;
    // ...