@Autowired
private AbstractApplicationContext context;

private void registerListeners() {
    ProjectsRepositoryListener firstListener = beanFactory.createBean(ProjectsRepositoryListener.class);
    context.addApplicationListener(firstListener);

    MySecondListener secondListener = beanFactory.createBean(MySecondListener.class);
    context.addApplicationListener(secondListener);
}