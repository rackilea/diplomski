public class MyTapestryModule {
  @Match("*Service")
  public <T> T decorateTransactions(Class<T> serviceInterface,
                                    T delegate,
                                    String serviceId,
                                    HibernateTransactionDecorator decorator) {
    return decorator.build(serviceInterface, delegate, serviceId);
  }
}