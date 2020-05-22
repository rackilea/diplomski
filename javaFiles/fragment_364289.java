default String diagnosisToString(Diagnosis diagnosis) {
    return diagnosis == null ? null : diagnosis.getDiagnosisCode();
}

default Diagnosis stringToDiagnosis(String diagnosisCode) {
    return diagnosis == null ? null : new Diagnosis(diagnosisCode);
}