final String msg = "You've requested an invalid vehicle type. Please only enter ";
boolean success = false;
do {
    try {
        orderNewVehicle(Orders);
        success = true;
    }
    catch (InvalidUserInputException e){
        System.out.println(msg + e.getValidVehicles());
    }
} while (!success);