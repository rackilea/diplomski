public boolean checkingObjectName(String checkName)
{
    for (int i=0; i<count; i++) //where 'count' has a value of 3
    {
        if (product[i].getName().equals(checkName)) //where product[i] has been initialised
        {
            return true;
        }
    }
    return false;
}