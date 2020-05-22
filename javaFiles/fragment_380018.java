int nextIdea = 0;
while(!select.equals("q")){
    System.out.println("What would you like to do?");
    System.out.println("\t 1. See next suggestion.");
    System.out.println("\t 2. <Another option>");
    System.out.println("\t 3. <Another option>");
    select = in.next();

    switch(select){
        case "1":
            System.out.println("\tToday: " + meals.get(nextIdea));
            nextIdea++;
            System.in.read();
            break;
    }
}