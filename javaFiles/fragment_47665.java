ObjectInputStream ois=new ObjectInputStream(fin);
 abc temp; 
  while((temp=(abc)ois.readObject()))
{
  System.out.println(temp);
  }