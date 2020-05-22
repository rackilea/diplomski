String tempStr;
 for (int t=0; t<eAthlete.length-1; t++)
    {
        for (int i= 0; i < eAthlete.length - t -1; i++)
        {
            if(eAthlete[i+1].getName().compareTo(eAthlete[i].getName())<0)
            {
                tempStr = eAthlete[i].getName();
                eAthlete[i].setName(eAthlete[i+1].getName());
                eAthlete[i+1].setName(tempStr);
            }
        }
    }