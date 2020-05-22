public void addCars(int id, String model, int year, double price) {
    if(nCars < MAXSIZE) { // check if the number of cars is less than MaxSize to add
        for(int i = 0; i<MAXSIZE; i++) { // go through the all the cars in the list
            if(Cars[i] != null) { // check if the car in this index is not empty
                if(id == Cars[i].getId()) { // check the id of the car is the same in the list
                    System.out.println("The car is already added"); // print already added if so
                    break; // break since you found a duplicate (an existing car id)
                }
            }else { // you come to this logic because the Car object in the index (i) is empty which means there is no car added
                   // since you add car sequentially in the car list then its safe 
                Car carObj = new Car(id, model, year, price);
                Cars[i] = carObj; // set the car object
                nCars++;  // increment the current car size 
                System.out.println("Added");
                break; // break since you have added the car to the list and no need to go through the for loop
            }
        }
    }
    else 
        System.out.println("ERROR: ADDING LIST IS FULL");
}