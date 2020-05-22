Scanner sc=new Scanner(System.in);
System.out.println("Unesi putanju");
File f = new File(sc.nextLine());
System.out.println("Unesi funkciju");
switch(sc.next()) 
{
    case "info":
       File f = new File(sc.nextLine());
        if (f.exists())
            System.out.println(f.getName()+"exist!");
        else 
            System.out.println("this folder/file doesnt exist");
    break;