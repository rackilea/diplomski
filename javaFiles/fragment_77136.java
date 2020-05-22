public static void main(String[] args) {
    ArrayDeque<Patient> Patients = new ArrayDeque(25);
    for(int i = 0;i<25;i++){
        Patient p = new Patient("Patient No " + i);
        (new Thread (p)).start();
        Patients.add(p);

    }
}