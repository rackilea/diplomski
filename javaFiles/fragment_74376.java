public static void loadStudent(Vector<Student>v)throws IOException
{
    Student stu;
    int c;
    DataInputStream f= new DataInputStream(
            new FileInputStream("Student.data"));
   try {
       // CHANGE HERE IS IMPORTANT
       while(f.available() > 0)
       {
           stu=new Student();
           int id=f.readInt();

           stu.setID(id);
           String name= f.readUTF();
           stu.setName(name);
           int age= f.readInt();
           stu.setAge(age);
           v.add(stu);
           // This read char is important since it's one user per line.
           f.readChar();
       }
   }
   catch(EOFException e)
   {
       System.out.println("Error!: End of File Exception");
       f.close();
   }
   catch(IOException e)
   {
       System.out.println("Error Reading File");
       f.close();
       System.exit(1);
   }
    f.close();
}