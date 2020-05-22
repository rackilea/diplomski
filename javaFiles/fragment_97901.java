public static void main(String[] args){
Scanner s = new Scanner(System.in);
System.out.print("Enter size of table: ");
int x = s.nextInt();
int r = 0;
int l = 0;
int f = 0;
for(int i=1;i<=x;i++){    
    for (int j=1; j <=x; j++)
    {
       r = r + j;
       System.out.print(i*j+"\t"); 
    }
    System.out.print(r);
    System.out.println();
    System.out.println();
    l=l+i;
}
for(int k = 1; k<=x;k++)
{
f=f+l;
System.out.print(f + "\t");
}