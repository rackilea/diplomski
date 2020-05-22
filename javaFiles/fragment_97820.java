try {
    Truck truck = (Truck) vehicle;
    // No exception: obj is of type Truck or IT MIGHT BE NULL!
   //here null value will also be type casted if present
} catch (ClassCastException e) {
}