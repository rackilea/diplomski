public int daysOfMonth(int getMonth, boolean isLeapYear)
{
    if (getMonth==1)        //jan
       return 31;

    //---------------------------------------Feb
    if (isLeapYear && getMonth==2)
       return 29;
    }

    if (/* !isLeapYear && */ getMonth==2)
       return 29;
    }
    //---------------------------------------Feb

    if (getMonth==3)        //march
       return 31;
    if (getMonth==4)        //april 
       return 30;
    if (getMonth==5)        //may
       return 31;
    if (getMonth==6)        //june
       return 30;
    if (getMonth==7)        //july
       return 31;
    if (getMonth==8)        //august
       return 31;
    if (getMonth==9)        //sept
       return 30;
    if (getMonth==10)       //oct
       return 31;
    if (getMonth==11)       //nov
       return 30;
    if (getMonth==12)       //dec
       return 31;   


    return -1; // error
}