public static void storeStudent(Vector<Student>v) throws IOException
{
    Student stu= new Student();
    DataOutputStream s= new DataOutputStream(
            new FileOutputStream("Student.data"));
    for(int i=0; i<v.size(); ++i)
    {
        stu=v.get(i);
        s.writeInt(stu.getID());
        s.writeUTF(stu.getName());
        s.writeInt(stu.getAge());
        // One user per line
        s.writeChar('\n');
        }
    s.close();
}