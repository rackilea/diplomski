case 2:
    store = new Store();

    if(store.deleteVehicle(vehicle) == false)
    {
        System.out.println("Vehicle not deleted");
    }
    run();
    break;