do {           
           System.out.println("Would you like to enter an ingredient: (y or n)");
           String reply = scnr.next().toLowerCase();

             if (reply.equals("y")) {
               System.out.println("Enter ingredient name: "); 
               newIngredient = scnr.next();   
               ingredientList.add(newIngredient);
               continue;
           }
             else if (reply.equals("n")) {
                System.out.println("Goodbye!");
                break;
             }

            else {
            System.out.println("Invalid option!");
            continue;
            }   
 } while (addMoreIngredients);