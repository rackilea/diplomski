public class Billing {

private Patient p;
private Doctor dr;

public Billing(Patient p, Doctor dr) {
    this.p = p;
    this.dr = dr;
}

public Doctor getDoctor() {
    return dr;
}

public void setDoctor(Doctor newDoctor) {
    dr = newDoctor;
}

public Patient getPatient() {
    return p;
}

public void setPatient(Patient newPatient) {
    p = newPatient;
}
}