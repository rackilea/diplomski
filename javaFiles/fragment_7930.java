public interface PaymentFactory {
   Payment create(
       @Assisted("startDate") Date startDate,
       @Assisted("dueDate") Date dueDate,
       Money amount);
 }