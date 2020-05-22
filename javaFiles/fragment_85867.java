public interface MyService {

  @CommitAfter
  void doSomeWork(Entity entity);

}

public class MyTapestryModule {
  @Match("*Service")
  public void adviseTransactions(HibernateTransactionAdvisor advisor,
                                 MethodAdviceReceiver receiver) {
    advisor.addTransactionCommitAdvice(receiver);
  }
}