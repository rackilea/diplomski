else if(userInput.compareToIgnoreCase("REMOVE") == 0){//If user input is REMOVE
    System.out.println("Type name of vehicle to be removed: ");//Ask for vehicle name to be remove
    String vehicleName = scan.nextLine();
    for(String setOfvehicle :setOfvehicles){
        if(setOfvehicle.equals(setOfvehicle)){
            setOfvehicles.remove(vehicleName);
        }
    }
}