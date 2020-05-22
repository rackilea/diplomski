public static void main(String[] args) throws Exception {
    JdbcTemplate template = new JdbcTemplate();
    Object proxy = Proxy.newProxyInstance(template.getClass().getClassLoader(), template.getClass().getInterfaces(), new ProxyJdbcTemplateHandler(template));
    System.out.println(proxy.getClass());
    System.out.println(proxy.getClass().getSuperclass());
    System.out.println(Arrays.toString(proxy.getClass().getInterfaces()));
}

public static class ProxyJdbcTemplateHandler implements InvocationHandler {
    private JdbcTemplate target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // do something with target
        return null;
    }

    public ProxyJdbcTemplateHandler(JdbcTemplate target) {
        this.target = target;
    }
}