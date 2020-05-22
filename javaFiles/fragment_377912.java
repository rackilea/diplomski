private @Autowired AutowireCapableBeanFactory beanFactory;

public void doStuff() {
   MyBean obj = new MyBean();
   beanFactory.autowireBean(obj);
   // obj will now have its dependencies autowired.
}