for (int count=0; count <= tempNum3; count++)
    {
        if (count == 7) tempNum1 = 0;
        else if (count==0) continue; //this is a patch, since there would be a confusion if the user inputted 1 for the addtional day
        else tempNum1++;
    }