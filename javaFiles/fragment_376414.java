public static void searchDetailsID() {
        boolean isFound = false;
        System.out.print("Please enter an passenger id: ");
        long id = kb.nextLong();

        for(int i = 0; i < passengers.length; i++) {
            if(passengers[i] != null /* I append this check*/ && id == passengers[i].getId()) {
                passengers[i].outputDetails();
                isFound = true;
                break;
            }
        }

        if(!isFound) {
            System.out.println("No passenger with that id!");
        }
    }