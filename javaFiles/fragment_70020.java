Scanner sc = new Scanner(System.in);
          System.out.println("How many times?");
          int noOfTimes = sc.nextInt();

       do{

          myFinch.setLED(Color.green);
          myFinch.setWheelVelocities(180, 0, 750);
          myFinch.setWheelVelocities(100, 100, 1500);

          myFinch.setLED(Color.red);
          myFinch.setWheelVelocities(0, 180, 850);
          myFinch.setWheelVelocities(180, 180, 1500);
          noOfTimes--; 

       }while(noOfTimes > 0);