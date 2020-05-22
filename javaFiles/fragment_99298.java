@Autowired
  @Qualifier(value="hibernate4AnnotatedSessionFactory")
  private SessionFactory hibernate4AnnotatedSessionFactory;

  @Autowired
  @Qualifier(value="hibernate4AnnotatedSessionFactory_extended")
  private SessionFactory hibernate4AnnotatedSessionFactory_extended;