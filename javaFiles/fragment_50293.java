public void removeStudent(Student student) {
    int[] new_list = new Student[list.length-1];
    int j = 0;
    for (int i = 0; i < list.length; i++) {
        if(list[i].getID() != student.getID()) {
            new_list[j] = list[i];
            j++;
        }
    }
    list = new_list; //Assuming list is some global
}