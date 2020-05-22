public class Vehicle {
   private int id;
   private String make;
   private String model;

   public Vehicle(){}

   public Vehicle(int id, String make, String model){
       this.id=id;
       this.make=make;
       this.model=model;
   }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString(){
        return this.model + " " + this.make + " " + this.id;
    }

}