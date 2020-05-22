public patient_class findPatient(List<patient_class> patients, String search) {
    for(patient_class patient: patients) //used  enhanced for loop
        if(patient.getid().equals(search))
        {
           return patient;
        }
    }
    return null; // no patient found matching the search id
 }

 public int calculatePatientTotal(List<patient_class> patientsList1, List<patient_class> patientsList2, String search){
    patient_class patientInList1 = findPatient(patientsList1,search);// assuming unique id
    patient_class patientInList2 = findPatient(patientsList2,search);// assuming unique id

    int total=0;
    // calc general total
    if(patientInList1!=null{
        // I'm assuming you put these getters in methods instead of public properties!
        // hence the brackets at the end
        total= patientInList1.gettotaltestcost() + patientInList1.gettotaltreatmentcost();
    } 

    // add any extra charges
    if(patientInList2!=null ){
        // I'm assuming this is the method that calculates the other charges in that patient object.
        total+= patientInList2.getOtherCharges();
    }

    return total;
 }