public void testFindPatientWherePatientExists() {
    Patient thePatient = surgery.findPatient("Teddy");
    assertEquals("Teddy", thePatient.getName());
}

public void testFindPatientWherePatientDoesntExist() {
    assertNull(surgery.findPatient("I dont exist"));
}