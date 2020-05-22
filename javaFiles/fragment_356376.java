LinkedList<String> hobbies = new LinkedList<String>(); 

//...

 hobbies.clear();

    if (cb_cricket.isSelected()) 
    {
        hobbies.add("Cricket");

    }
    if (cb_football.isSelected()) 
    {
        hobbies.add("Football");

    }
    if (cb_tennis.isSelected()) 
    {
        hobbies.add("Tennis");

    }

    if (hobbies.size() == 0) 
    {
        b = " nothing";
    } 
    else 
    {
        for (int j = 0; j < hobbies.size(); j++) 
        {
            if( j > 0)
            {
                if(j == hobbies.size()-1)
                {
                    b += " and ";
                }
                else
                {
                    b += ", ";
                }
            }

            b+= hobbies.get(j);
        } 

        if (hobbies.size() == 1) 
        {

            b += " only";

        }

        b += ".";

    }