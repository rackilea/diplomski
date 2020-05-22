public class WebServiceBinder extends AbstractBinder {

  @Override
  protected void configure() {
    BeanManager bm = getBeanManager();
    bind(getBean(bm, StudentRepository.class))
        .to(StudentRepository.class);
  }

  private BeanManager getBeanManager() {
    // is there a better way to get the bean manager?
    return new Weld().getBeanManager();
  }

  private <T> T getBean(BeanManager bm, Class<T> clazz) {
    Bean<T> bean = (Bean<T>) bm.getBeans(clazz).iterator().next();
    CreationalContext<T> ctx = bm.createCreationalContext(bean);
    return (T) bm.getReference(bean, clazz, ctx); 
  }
}