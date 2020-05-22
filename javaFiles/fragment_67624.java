public void enrollStudent(Student newStudent)
{
    if(students.size() == capacity) {
        System.out.println("The class is full, you cannot enrol.");
    }
    else {
        newStudent.addCredits(50);
        students.add(newStudent);
    }

}