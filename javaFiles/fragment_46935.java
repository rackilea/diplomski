String month = "Feb";
int count = 0;
while ((line = br.readLine()) != null) 
{
   String strDate = line.split("\\s+")[0]; // get first column, which has date
   String temp = strDate.split("\\-")[1]; // get Month from extracted date.
   if (month.equalsIgnoreCase(temp))
   {
      count++;
      // or store strDate into List for further process.
   }
}
System.out.println (count);// should print total occurrence of date with Feb month