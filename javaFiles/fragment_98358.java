public void displayStudentsReport()
{
  System.out.println("***** Display Students Report *****");
  System.out.println();

  for (int i = 0; i < students.length; i++)
  {
     String comp;
     comp = students[i].getStudentID();
     students[i].printStudentDetails();
     // print job details for each student
     boolean studentHasJob = false;
     for (int j = 0; j < currentJobs.length; j++)
     {
        if(currentJobs[j].getStudentID().equalsIgnoreCase(comp)) {
            studentHasJob = true;
            currentJobs[j].printJobDetails();
        }
     }
     if(!studentHasJob){
         System.out.println("Student " + comp + " has no jobs");
     }
  }


  }