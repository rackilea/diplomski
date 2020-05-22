Scanner myObj = new Scanner(System.in);
    String day = myObj.nextLine();
    switch(day) {
        case "morning" :
            System.out.println("Good Morning"); break;
        case "afternoon":
            System.out.println("Good Afternoon"); break;
        case "evening":
            System.out.println("Good evening!"); break;
        case "night" :
            System.out.println("Good night"); break;
        default:
            System.out.println("Good Day");
    }