for (Student student : S) {
    for (Patient patient : P) {
        if (student.getName().equals(patient.getName())) {
            count++;
        }
    }
}