public void SearchByPatientId(Patient[] patient) {
    //take input from user
    for (Patient patient : patient) {
        if (patient.id == storesearchid){
            //found.. do whatever you want
            break;
        }
    }