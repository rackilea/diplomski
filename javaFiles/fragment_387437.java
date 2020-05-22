public class Cash extends ValueItem{
   ...
}

public class Equity extends ValueItem implements UnitPricable{
   ...
}

public class Fund extends ValueItem implements UnitPricable{
   ...
}


public class Person{
   private List<Cash> cashes = new ArrayList<>();
   // the next one groups two kind of subclasses
   private List<UnitPricable> unitPricables = new ArrayList<>();
   ....

   // operations that works on the Cash subclass instances
   public void computeCashes(){
     for (Cash cash : cashes){
        ... = cash.getSpecificCashField();               
        ... = cash.specificCashMethod();               
        ...
     }
   }

   // operations that work on multiple subclasses instances : Fund and Entity
   public void computeUnitPricables(){
     for (UnitPricable up: unitPricables){
        ... = up.getUnitPrice();               
        ... = up.specificUnitPriceMethod();               
        ...
     }
   }
}