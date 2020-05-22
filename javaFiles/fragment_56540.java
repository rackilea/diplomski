private String getUserName() {
    AccessControlContext acc = AccessController.getContext();
    Subject subject = Subject.getSubject(acc);
    if (subject != null)  {
    Set<JMXPrincipal> principals = subject.getPrincipals(JMXPrincipal.class);
    JMXPrincipal principal = principals.iterator().next();
    return principal.getName();
    }
    return "";
}