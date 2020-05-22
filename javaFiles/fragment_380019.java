case "1":
    if(nextIdea >= meals.size()) {
        nextIdea = 0;
    }
    System.out.println("\tToday: " + meals.get(nextIdea));
    nextIdea++;
    System.in.read();
    break;