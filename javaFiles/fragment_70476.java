private @Autowired BeanFactory beanFactory;

@RequestMapping("/blabla")
public void perform (@RequestParam String strategyName) {
    Strategy strategy = beanFactory.getBean(strategyName, Strategy.class);
    strategy.doStuff();
}