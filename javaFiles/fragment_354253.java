public void setAdmissionPolicyAdmitOnly(List<String> newValidNames) {
    admissionPolicy = new AdmitOnlyPolicy(newValidNames);
}

public void setAdmissionPolicyAdmitAllBut(List<String> newInvalidNames) {
    admissionPolicy = new AdmitAllButPolicy(newInvalidNames);
}