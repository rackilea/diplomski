public class CardContainer extends ... {

   CardContainerEventListener mCallback;

   // Define a interface
   public interface CardContainerEventListener {
       public void addToAdapter();
   }

   // Method to register callback
   void registerCallback(Activity callback) {
       mCallback = (CardContainerEventListener) callback;
   }

   void someFunction() {
       // Event got generated, invoke callback method
       mCallback.addToAdapter(); 
   }
}

public class MainActivity extends Activity implements CardContainer.CardContainerEventListener {

    // Ensure you register MainActivity with CardContainer, by calling 
    // cardContainer.registerCallback(this)

    public void addToAdapter() {
       adapter.add(...);
    }   

}