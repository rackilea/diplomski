public String[] getAllIncompleteRequiredClasses()
{
    int counter = 0;
    boolean match =false;
    for(int k = 0; k < requiredGeneralClasses.length; k++)
    {
        for(int i = 0; i < count; i++)
        {

            //System.out.println(requiredGeneralClasses[k] + " "+ completedClasses[i]);
            if(requiredGeneralClasses[k].equalsIgnoreCase(completedClasses[i]))
            {
                match=true;
                break;
            }
        }
        if(!match)
        {
            //inCompleteClasses[counter] = new String();
            inCompleteClasses[counter] = requiredGeneralClasses[k];
            counter++;
        }
        match = false;
    }

    for(int k = 0; k < requiredInMajorClasses.length; k++)
    {
        for(int i = 0; i < count; i++)
        {

            //System.out.println(requiredGeneralClasses[k] + " "+ completedClasses[i]);
            if(requiredInMajorClasses[k].equalsIgnoreCase(completedClasses[i]))
            {
                match=true;
                break;
            }
        }
        if(!match)
        {
            inCompleteClasses[counter] = requiredInMajorClasses[k];
            counter++;
        }
        match = false;
    }
    return inCompleteClasses;
}