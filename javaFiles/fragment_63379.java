public class PaymentStrategyFactory {

  private static ApplicationContext context;
  private ApplicationContext applicationContext;

  @Autowired
  private PaymentStrategyFactory(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @PostConstruct
  private void initializeApplicationContext() {
    PaymentStrategyFactory.context = applicationContext;
    this.applicationContext = null;
  }

  @Override
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    PaymentStrategyFactory.context = context;
  }

  public static PaymentStrategy getPaymentStrategy(AccountType payerAccountType,
                                                   AccountType sellerAccountType) {
    if (sellerAccountType == AccountType.COMPANY) {
      switch (payerAccountType) {
        case EMPLOYEE:
          return context.getBean(EmployeePaymentStrategy.class);
          // return new EmployeePaymentStrategy();
        case BASIC_USER:
           ...
        }
     } 
     throw ...
   }
}