int car=0;
    while(car==0)
    {
        if(q.equalsIgnoreCase("BMW")||q.equalsIgnoreCase("AUDI"))
            car++;
        else
        {
            System.out.println("Sorry that is not a car manufacturer listed           (AUDI/BMW)");
            System.out.println("Choose from Audi or BMW");
            q = input.next();
        }

    }
if (q.equalsIgnoreCase("BMW")){ // Prints BMW Car Specifications
      System.out.println("Here is the latest BMW Car specifications:");
      System.out.println("Colour: " + V1.getColour());
      System.out.println("Fuel Capacity: " + V1.getFuel() + " Liters");
      System.out.println("Wheel count: " + V1.getWheels());
      System.out.println("Maximum Speed: " + V1.getMaxSpeed() + " KM/H");

  }else if(q.equalsIgnoreCase("AUDI")){ //Prints AUDI Car Specifications
      System.out.println("Here is the latest AUDI Car specifications:");
      System.out.println("Colour: " + V2.getColour());
      System.out.println("Fuel Capacity: " + V2.getFuel() + " Liters");
      System.out.println("Wheel count: " + V2.getWheels());
      System.out.println("Maximum Speed: " + V2.getMaxSpeed() + " KM/H");
    }