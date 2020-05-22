public void displayUnits() {
    for (int i =0; i<units.length; i++) {
        System.out.println(units[i].description());

        for (Student student: units[i].getStudents()) {
            System.out.println(student.description());
        }  
    }
}