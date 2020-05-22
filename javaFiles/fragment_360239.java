@Autowired
private ApplicationContext applicationContext;

[...]

applicationContext.getAutowireCapableBeanFactory().getBean(clazz_name);