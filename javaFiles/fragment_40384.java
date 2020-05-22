public static String[] getcontestants()
{
    int numcontestants=8;
    String name[] = new String[numcontestants];

    for(int j=0;j<numcontestants;j++){
        Scanner ip=new Scanner(System.in);
        System.out.println("Enter contestant's name");
        name[j]=ip.nextLine();
    }
    return name;
}