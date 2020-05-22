public static static void main(String args[]){
       List<String> states = new ArrayList<>();
       whereAreYouFrom(states);
    }

   public static void whereAreYouFrom(List<String> states){
           System.out.print("Where are you from? ");
           states.add(scanner.next());

            if (states.contains("Florida") || states.contains("florida")) {
              System.out.println("So was I!\n");
               return;
             }

            if (states.contains("North Carolina") || states.contains("north carolina")){ 
                System.out.println("I hear that's a nice place to live.\n");
                return;
             }

            System.out.println("I would have never guessed!");
      }