for (int i = 0; i < array.size(); i++)
{
    if (array.get(i).compareTo(aStudent) == 0)
    {
        System.out.println(aStudent.equals(array.get(i)));
        found = true;
        break; // out of loop
    }
}
System.out.println(found);