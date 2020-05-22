System.out.print("What is the car's year model? ");
         yearModel = sc.nextDouble();

         boolean isInRange = (1940 <= yearModel） && (yearModle <= 2016);

         if(!isInRange){
             // not in range
             return;
         }

         sc.nextLine(); // consumes the left-over newline character.

         System.out.print("What is the make of the car? ");
         make = sc.nextLine();