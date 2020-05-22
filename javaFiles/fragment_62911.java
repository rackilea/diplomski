while ((line = Ubr.readLine()) != null) //Reads the file till the end.
{
  if (line.trim().length() == 0) {
    continue;
  }
  if (!line.startsWith(String.valueOf(getValueAt(index, 0)))) //If line starts with 86 don't write it to new `Uoutput.txt`. so all lines starting with 86 will be ignored.
  {
     Upw.println(line);//Lines starting with 86 is not written.
   }
 }