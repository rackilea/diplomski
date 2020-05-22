for (Student student : students)
{
    if (student.getName().equals(search))
    {
        System.out.println(student);
        break;//assuming student name are unique. remove if not
    }
}