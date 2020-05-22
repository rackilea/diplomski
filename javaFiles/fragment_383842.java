@Test
public void test() {
    login("customer", "password", "ROLE_CUSTOMER");
    // ...
    login("admin", "password", "ROLE_ADMIN");
    // ...
}

static void login(String username, String password, String... roles) {
    SecurityContext context = SecurityContextHolder.createEmptyContext();

    User user = new User(username, password, roles(roles));

    Authentication auth = new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
    context.setAuthentication(auth);
    SecurityContextHolder.setContext(context);
}

static List<SimpleGrantedAuthority> roles(String... roles) {
    return Arrays.stream(roles).map(SimpleGrantedAuthority::new).collect(toList());
}