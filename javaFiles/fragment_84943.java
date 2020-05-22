public void actionPerformed (ActionEvent event)
{
    String name = nameField.getText();
    String major = majorField.getText();
    double gpa = Double.parseDouble(gpaField.gtText());
    int id = Integer.parseInt(idField.getText());

    Student s = new Student(id, name, major, gpa); // or whatever your constructor looks like.
    Student s1;
    for (int i = 0; i < firstSchoolOfJava.getStudents().size(); i++){
        s1 = firstSchoolOfJava.getStudents().get(i);
        if (s1.getId() == id){
            firstSchoolOfJava.getStudents().set(i, s);
            break;
        }
    }   
}