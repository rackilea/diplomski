@Autowired
ConfigurableApplicationContext context;
.....
ConfigurableListableBeanFactory beansFactory = context.getBeanFactory();
String[] beansNames =  beansFactory.getBeanDefinitionNames();
Set<String> beansType = new HashSet<>();

for(String beanName : beansNames){
    if (beanName.matches("(.*)Controller")){
       beansType.add(beansFactory.getType(beanName).toString());
    }
}