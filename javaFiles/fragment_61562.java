public Appointment addAppointment() {
    // we have to access the reference when the method returns
    Appointment object = new Appointment();
    object.inputAppoitment();
    return object; // we return the reference to object and asign it into array[5]
}