public class SessionListener implements HttpSessionListener {
    @Autowired
    DataSourceMap dataSourceMap;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("tworzenie sesji");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println(httpSessionEvent.getSession().getId());
        dataSourceMap.removeSource(httpSessionEvent.getSession().getId());
    }
}