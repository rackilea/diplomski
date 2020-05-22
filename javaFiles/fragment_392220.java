cheak = 0;
for ( String student : studentNames)
    {  
        if (nameInput.equals(student))
        {
            break;
        }
        cheak++;
    }
if (cheak != numberOfStudents)
{
    System.out.println("Name Found. Name = " + studentNames[cheak] + " Grade = " + StudentGrades[cheak]);
}
else
{
    System.out.println("Name Not Found");
}