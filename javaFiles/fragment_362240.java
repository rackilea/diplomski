public static String[] dirReduc(String[] arr) {
    int directionNS = 0;
    int directionEW = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == "NORTH") {
            directionNS++;
        } else if (arr[i] == "SOUTH") {
            directionNS--;
        } else if (arr[i] == "EAST") {
            directionEW++;
        } else if (arr[i] == "WEST") {
            directionEW--;
        } else {
            System.out.println("Invalid Direction.");
        }
    }


    String[] reducArray;
    //removed special case for ending up back where one started, that will be made a 0 length array as it should be
    reducArray = new String[Math.abs(directionNS) + Math.abs(directionEW)]; //note have to take abs of each so one does not cancel out the other
    if (directionNS > 0) {
        for (int i = 0; i < directionNS; i++) {
            reducArray[i] = "NORTH";
        }
    } else if (directionNS < 0) {
        for(int i = 0; i < Math.abs(directionNS); i++){//keep the i's positive so they work in the array easily
            reducArray[i] = "SOUTH";
        }
    }


    if (directionEW > 0) {
        for (int i = 0; i < directionEW; i++) {
            reducArray[i + Math.abs(directionNS)] = "EAST"; //note have to start where north south left off
        }
    } else if (directionEW < 0) {
        for(int i = 0; i < Math.abs(directionEW); i++){
            reducArray[i + Math.abs(directionNS)] = "WEST";
        }
    }

    return reducArray;
}`