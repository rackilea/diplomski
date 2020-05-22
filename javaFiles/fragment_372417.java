@Test
public void testSaveDoctor(){

    Doctor firstDoctor = new Doctor();
    firstDoctor.setFirstName("test doc");
    firstDoctor.setLastName("lname doc");

    Patient firstPatient = new Patient();
    firstPatient.setFirstName("patient 1");
    firstPatient.setLastName("patient lname1");

    firstDoctor.getPatients().add(firstPatient);
    firstPatient.getDoctorList().add(firstDoctor);

    rDoctor.save(firstDoctor);
}