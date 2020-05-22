public static void printStudents(Student[] students)
{   
    // Check if the array is null, good practice.   
    if(students == null)
        return;

    System.out.println("Students:");

    for (int i = 0; i < students.length; i++)
    {   
        // My hack: Check if element is null, if it is then skip it.
        if(students[i] == null)
            continue;

        System.out.println(students[i].toString());
    }

    System.out.println();
}