class Vehicle(){

     //YOUR OTHER PIECES OF CODES ...

     private static Vehicle firstLargeVehicle;
     private Vehicle nextLargeVehicle;
     private int index;

     public void setIndex(int index){
          this.index = index;
          if(index == 0) Vehicle.firstLargeVehicle = this;
     }

     public int getIndex(){
          return index;
     }

     public void setNextLargeVehicle(Vehicle nextLargeVehicle){
          this.nextLargeVehicle = nextLargeVehicle;
     }

     public Vehicle getNextLargeVehicle(){
          return nextLargeVehicle;
     }

     public addLargeVehicle(Vehicle newVehicle){
          this.nextLargeVehicle = newVehicle;
          newVehicle.setIndex(index + 1);
     }

     public getListSize(){
          Vehicle lastOne = this;
          while (lastOne.getNextLargeVehicle() != null){
              lastOne = lastOne.getNextLargeVehicle();
          }

          return lastOne.getIndex() + 1;
     }

     public static Vehicle[] largeVehiclesToArray(){
          Vehicle[] result = new Vehicle[firstLargeVehicle.getListSize()]();
          Vehicle pointer = firstLargeVehicle;
          for (int counter = 0; pointer != null; counter ++){
              result[counter] = pointer;
              pointer = pointer.getNextLargeVehicle();
          }

          return result;
     }

 }