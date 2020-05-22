boolean recordsAvailable = false;
int lastRecord = 0;

recordsAvailable = rs.next;

while (recordsAvailable)
{
   lastRecord  = rs.getInt("MY_VALUE");
   // Do all actions here... 
   ....
  // Towards the end of the loop, 
   if (rs.next)
   { 
       // Records available
   } 
   else
   {
      // Last record 
      // Do actions with the variable lastRecord
       recordsAvailable= false;
   }

}