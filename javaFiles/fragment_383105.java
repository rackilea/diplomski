switch (search)
{
    case 1:
        for (int i=0; i<addressBook.size(); i++)
        {   
            if(value.equals(addressBook.get(i).getFirstName()))
            {
                indexFound = i;
                return;
            }                   
        }
        break;
    case 2:
    // etc.