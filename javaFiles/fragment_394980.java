for (int i = 0 ; i<lineNum; i++)
{
  while (str!= null)
  {
    names[i] = str;
    str = br1.readLine();
    System.out.println(names[i]); 
  }             
}