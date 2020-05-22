for (patient_class patient : patients) {
    if (patient.getid().equals(search)) {
        return patient;
    }
}
// Only return null if we've checked *all* patients
return null;