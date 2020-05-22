double highest = students[0].getGrade();
for (Student s : students) {
    if (s.getGrade() > highest) {
        highest = s.getGrade();
    }
}