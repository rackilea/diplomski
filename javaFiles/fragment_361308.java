for(x = 0; x < monthID.length; ++x)
    {
      if(((month.equals(monthValidSingleInputs[x])) || (month.equals(monthValidDosInputs[x]))) && 
          (intDay <= intDaysArray[x]) && ((intMonth >= JANUARY) && (intMonth <= DECEMBER)))
      {
           JOptionPane.showMessageDialog(null, "Date is: " + monthID[x] + " " + intDay + ", " + year);
           flag=true;
           break;
      }
     }

     if(flag==false)
       JOptionPane.showMessageDialog(null, "Please re-run program, entries not valid.");
  }
}