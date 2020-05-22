@Override
public Medication initMedication(PatientInformation patient, int index) {
    ServiceUtils.assertNotNull("A patient is required", patient);
    Medication medication = patient.getMedicationList().get(index);
    medication.setDosageFrequencySet(
                  convertSelectedDosageFrequencyList(medication.getDosageFrequency()));
    return medication;
}

@Override
public void updateMedication(PatientInformation patient, Medication medication) {
    if (!patient.getMedicationList().contains(medication)){
        medication.setDosageFrequency(
               convertSelectedDosageFrequency(medication.getDosageFrequencySet()));
        patient.getMedicationList().add(medication);
    }
}

private String convertSelectedDosageFrequency(LinkedHashSet<String> dosageFrequencies){
    String frequencies = StringUtils.join(dosageFrequencies," ");
    return frequencies;
}

private  LinkedHashSet<String> convertSelectedDosageFrequencyList(String dosageFrequency){
    String copyOfDosages =dosageFrequency;
    LinkedHashSet<String> setofSelectedDosageFrequency = new LinkedHashSet<String> ();
    if  (copyOfDosages!= null && copyOfDosages.length()>0){
        for (String aFrequency: selectableDosageFrequencyList){
        if (copyOfDosages.contains(aFrequency)){
            setofSelectedDosageFrequency.add(aFrequency);
            copyOfDosages = copyOfDosages.replaceAll(aFrequency, "");
            copyOfDosages = copyOfDosages.trim();
        }
        }
    }   
    return setofSelectedDosageFrequency;        
}