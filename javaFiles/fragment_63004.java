//Sort
  public static void sort(Student[] students)
  {
    int j;
    boolean flag = true; // set flag to true to begin first pass
    Student temp;  //holding variable

    while (flag)
    {
      flag = false; //set flag to false awaiting a possible swap
      for (j = 0; j < students.length -1; j++)
      {
        if (students[j].compareTo(students[j+1]) < 0) // change to > for ascending sort
        {
          temp = students[j];  //swap elements
          students[j] = students[j+1];
          students[j+1] = temp;
          flag = true;  //shows a swap occurred 
        }
      }
    }
  }