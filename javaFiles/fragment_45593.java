public static Object getBean(String jndiName) throws NamingException {
    Object bean = null;
    Context ctx = new InitialContext();
    bean = ctx.lookup(jndiName);
    return bean;
}