for(patient_class patient: patients) //used  enhanced for loop
    if(patient.getid().equals(search))
    {
        return patient;
    }
    else
    {
        return null;
    }
return null;