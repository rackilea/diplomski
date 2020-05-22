private static LinkedList yearLister(int yearCount, int startingYear, int endYear){
    LinkedList years = new LinkedList();
    if (yearCount < 0){ yearCount = -yearCount; } 
    // yearCount can be negative. 
    // When that is the case, you won't be able to add elements to your   
    // list. This statement deals with that.

    if(startingYear > endYear){         
        for(int i = 0; i < yearCount; i++){
            years.add(endYear + i + 1 );
        }
    } else if (startingYear < endYear) {            
        for(int i = 0; i < yearCount - 1; i++){
            years.add(startingYear + i + 1);
            }
        }

    System.out.println(years);
    return years;
    }