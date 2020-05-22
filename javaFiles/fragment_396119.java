//TODO: A candidate for externalization into a config file once we have all the known rules
    medicalClaimValidations.add(new ValidationProcessTuple(serviceDateFromGreaterThanTo, false));
    medicalClaimValidations.add(new ValidationProcessTuple(procedureCodeLength, false));
    medicalClaimValidations.add(new ValidationProcessTuple(HCPCSCodeLength, false));
    medicalClaimValidations.add(new ValidationProcessTuple(typeOfBillPresenseAndLengthForInstitutionalClaims, false));
    medicalClaimValidations.add(new ValidationProcessTuple(dischargeStatusPresenseAndLengthForInpatientClaims, false));
    medicalClaimValidations.add(new ValidationProcessTuple(diagnosisCodeFormat, false));