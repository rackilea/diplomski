public class RealPayment implements Payment {
   @Inject
   public RealPayment(
      CreditService creditService,
      AuthService authService,
      @Assisted("startDate") Date startDate,
      @Assisted("dueDate") Date dueDate,
      @Assisted Money amount) {
     ...
   }
 }