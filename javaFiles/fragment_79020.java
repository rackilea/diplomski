import java.util.Scanner;
    public class Vert_Bar_Graph1
    { 
    public static void main()throws InterruptedException
    {
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter the total no. of subjects");
    int sub= sc.nextInt();
    char bloc= (char)9619;
    int marks[]=new int[sub];
    String na[]= new String[sub];
    System.out.println("Enter the name of the subject");
    String use=("");
    print o=new print();
    Career ob=new Career();
    char ch=(char)10032;
    for(int i=0; i<sub; i++)
    {
        na[i]= sc.next(); na[i]=na[i].toUpperCase();
    }

    for(int i=0; i<sub; i++)
    {
        System.out.println("Enter the marks out of 100 in 
          "+na[i]);
        marks[i]=sc.nextInt();
    }
    System.out.println("\f");round ze=new round();
    use=("\t\t\t\t "+ch+"bar graph"+ch+"\n");
    o.s(use);
    int count=100;
    for(int j=0; j<10; j++)
    {
        for(int k=0; k<sub; k++)
        {
            if(marks[k]>=count)
            {
                use=((char)9608+ "\t");//9608
                o.s(use);
            }
            else
            {
                use=((char)32+ "\t");
                o.s(use);
            }
        }
        System.out.println(); 
        count=count-10;
    }
    for(int i=0; i<sub; i++)
        System.out.print(na[i].substring(0,3)+"\t");//6 
                                            spaces 
        System.out.println();
        for(int i=0; i<sub; i++)
        System.out.print(marks[i]+"\t");//7 spaces 
        Thread.sleep(10000);

        }
            }