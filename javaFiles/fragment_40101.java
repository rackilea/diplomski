public static void stuIDWrite() throws IOException
 {
     Writer writer = null;

 try {
     writer = new BufferedWriter(new OutputStreamWriter(
       new FileOutputStream("Res/stuIDSorted.txt")));

 int i = 0;

while (i <= stuArrayIdSort.length + 1)
{
    ln = stuArrayIdSort[i].getStuLastName();    
    fn = stuArrayIdSort[i].getStuFirstName();
    pn = stuArrayIdSort[i].getStuFirstName();
    id = stuArrayIdSort[i].getStuId();
    ft = stuArrayIdSort[i].getFTime();
    phn =stuArrayIdSort[i].getPhoneNum();
    lj = stuArrayIdSort[i].getLovJava();
    con = stuArrayIdSort[i].getCont();
        writer.write(ln + "," + fn + "," + pn  + ","+ id + "," + ft + "," + phn + "," + lj + "," + con + "\n");
        i++;    
}
} catch (IOException ex) {
   // report
  } finally {
try {writer.close();} catch (Exception ex) {}
 }