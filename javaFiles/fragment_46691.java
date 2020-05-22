@EventListener
public void runOnStartup(ApplicationReadyEvent event) {
    try {
      do_stuff_that_might_runtime_exception();
   } catch(RuntimeException runtimeException){
      // Handle Exception Here 
      runtimeException.printStackTrace();
   }
}