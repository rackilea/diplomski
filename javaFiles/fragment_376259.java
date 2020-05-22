@Test
public testClassifier_emergencyNumberSupplied_correctnessConfirmed() {
    assertTrue(contactClassifier.isEmergencyNumber(ContactClassifier.EMERGENCY_PHONE_NUMBER));
}


@Test
public testClassifier_incorrectValueSupplied_correctnessNotConfirmed() {
    assertFalse(contactClassifier.isEmergencyNumber("111-other-222"));
}