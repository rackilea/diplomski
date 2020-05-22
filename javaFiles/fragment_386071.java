public boolean checkDuplicateName(String name)
{ 
 // check the whole ArrayList for a student with the same name
   for(Student s : students)
   {
        // compare the actual name strings
        if (s.studentName.equals(name)) return true;
    }
    return false;
}