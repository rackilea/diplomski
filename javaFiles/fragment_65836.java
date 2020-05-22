public static void main(String args[]) throws IOException
{
    Scanner in=new Scanner(System.in);
    int n;
    n=Integer.parseInt(in.nextLine());
    student[] s=new student[n];
    for(int i=0;i<n;i++)
    {
            s[i]=new student();
            s[i].name=in.nextLine();
            s[i].age=Integer.parseInt(in.nextLine());
            s[i].cgpa=Float.parseFloat(in.nextLine());

    }
    System.out.println();
    System.out.println("Name\tAge\tCGPA\n");
    for(int i=0;i<n;i++)
    {
        System.out.println(s[i].name+"\t"+s[i].age+"\t"+s[i].cgpa+"\n");
    }
}