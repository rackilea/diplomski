for (Patient patient : patients) {
    if (patient.getId().equals(search)) {
        return patient;
    }
}
return null;