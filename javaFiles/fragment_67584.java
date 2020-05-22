int FoundMarks = 0;
for(int i = 0; i < names.length; i++)
{
    if(names[i].equalsIgnoreCase(getName))
    {
        FoundMarks = marks[i];
        break;
    }
}
System.out.println("Marks of "+getName+": "+FoundMarks);