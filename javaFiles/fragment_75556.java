public static void main(String[] args) {
        String Day; // The user’s name.
        TextIO.put("This program is to tell you what to eat for today.");
        TextIO.put("\nBefore it starts, can you tell me what's the day today?");

        do
        {
        Day = TextIO.getln();

        if (Day.equals("Monday")){
            System.out.print("Eat Chocolates");
            break;
        }
        else if (Day.equals("Tuesday")){
            System.out.print("Eat Oranges");
            break;
        }
        else if (Day.equals("Wednesday")){
            System.out.print("Eat Strawberries");
            break;
        }
        else if (Day.equals("Thursday")){
            System.out.print("Eat Lemons");
            break;
        }
        else if (Day.equals("Friday")){
            System.out.print("Eat Bananas");
            break;
        }
        else if (Day.equals("Saturday")){
            System.out.print("Eat Apples");
            break;
        }
        else if (Day.equals("Sunday")){
            System.out.print("Eat Grass");
            break;
        }

        else if (Day.equals(false))
        {System.out.print("Error");
        System.out.print("\nPlease re-eneter the answer");
        }
     }while(true);
 }