Car {
   // possibly violates SRP
   storeInDatabase();  
   // smells like anemic domain model
   getEngineState();   
}