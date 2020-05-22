/* Qualifier annotation */
@Qualifier
@Retention(RUNTIME)
@Target({FIELD,METHOD})
public @interface Scope {

 Type value();

 enum Type { REQUEST, SESSION, APPLICATION };
}


/* Address class */
@Produces @Scope(REQUEST) @RequestScoped
 public Address request() {
 return new Address();
}

@Produces @Scope(SESSION) @SessionScoped
 public Address session() {
 return new Address();
}

/* Servlet */
@Inject @Scope(REQUEST)
private Address newAddress;

@Inject @Scope(SESSION)
private Address currentAddress;