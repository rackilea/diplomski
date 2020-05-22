int counter2 = 0; // reset counter    
for (Checkbox chk : allCheckboxes)  
    {   
       if (chk.isChecked() && isGreen(chk)) {
           counter2++;
       }  
    }   
    //...