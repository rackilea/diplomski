public class MainFrame extends JFrame {
   // your ProcessorCalculation field  
   private ProcessorCalculation processor;

   public MainFrame(ProcessorCalculation processor) {
      // set the field with ref passed in parameter
      this.processor = processor; 

      // of course other code goes here
   }

   public void someMainFrameMethod() {
      // use the reference
      processor.someProcessorMethod();
   }

}