public void addAppointment() {
     // this would be unreferenced when the method finishes
    Appointment object = new Appointment();
    object.inputAppoitment();
    array[5] = object; // so now array[5] refers to object;
} // object is no longer in scope, array[5] no longer has a reference to it