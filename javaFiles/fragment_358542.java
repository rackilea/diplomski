while (again) {

             // if the next is a double, print the value
             if (input.hasNextDouble()) {
                base = input.nextDouble();
                System.out.println("You entered base: " + base);
                again = false;
             } else {
                // if a double is not found, print "Not valid"
                System.out.println("Not valid :" + input.next());
                again = true;
             }


      }
    again = true;
    while (again) {

             // if the next is a double, print the value
             if (input.hasNextDouble()) {
                height = input.nextDouble();
                System.out.println("You entered height: " + height);
                again = false;
             } else {
                // if a double is not found, print "Not valid"
                System.out.println("Not valid :" + input.next());
                again = true;
             }


      }
      area = (base * height) / 2;