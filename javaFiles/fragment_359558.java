public int accelerate(Scanner in){
    while(in.hasNextInt()){
        currentSpeed = in.nextInt();
        if(currentSpeed > 50 && currentGear <= 1){
            System.out.println("We cannot accelerate to more than 50 km per hour, when shifting in the 1st gear!");
        } else if(isEngineOn && currentSpeed > 0){
          currentGear++;
          break; /* I've added this to break out of the method to progress in your flow */
        } else{
            System.out.println("We cannot depart at 0 km per hour!");
        }
      }
      return 0;
   }
}