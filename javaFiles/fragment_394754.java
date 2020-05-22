public static void main(String[] args) throws Exception {

    printStudents(Student2);  

}

public static void printStudents(ArrayList<String> studentList) {   
    for (int m = 0; m <= studentList.size()-1; m++)
    {
        System.out.println(studentList.get(m));
    }
}