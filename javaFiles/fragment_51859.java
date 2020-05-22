@Autowired
private BeanContainingThatMethod self;

    @EventListener(ContextRefreshedEvent.class)
      public void afterStartup() {
        self.preheatCache();
      }