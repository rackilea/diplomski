for(Iterator<Student> iter = students.iterator(); iter.hasNext(); ) {
    Student student = iter.next();
    if(studentName.equalsIgnoreCase(student.getName()) {
        iter.remove();
    }
}