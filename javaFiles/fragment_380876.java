public class MyEntity {
     private Long cost;

     //getters and setters...
     @AssertTrue
     public boolean isValid() {
          long minCost = MyExternalConfig.getMinCost(); //get data from where you want
          return cost > minCost; 
     }

}