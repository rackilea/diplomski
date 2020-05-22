@Autowired AutowireCapableBeanFactory beanFactory;

...

MyBean bean = new MyBean();
beanFactory.autowireBean(bean);
beanFactory.applyBeanPropertyValues(bean, bean.getClass().getSimpleName());