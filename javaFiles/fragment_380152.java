Food meat = new Meat("Steak");    // you create a Meat object and store it in a Food variable (so to speak)
try{     
    System.out.println("Wolves eat " + wolfExample.eat(meat));   // must be surrounded by a try-catch block
}catch(Exception ex){
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);  // better way to log the exception than ex.printStackTrace();
}