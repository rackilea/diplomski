public static void main(String args[])
 {
     Scanner Prakhar=new Scanner(System.in);
     System.out.println("Enter a Number");
     int x=Prakhar.nextInt();
     int z=x;

     // correct logic for computing number of digits
     int n=(int)Math.ceil(Math.log10(x)/Math.log10(2));

     System.out.println("No. of Digits="+n);
     int a[]=new int[n];
     int b=0;
     int j=0;
     while (z!=0)  // check if z != 0
     {
         x=z%2;
         System.out.println(x);
         a[j]=x;
         j++;
         z=z/2;
     }
     int l=a.length;

     //reverse print for printing correct binary number
     for(int i=l-1;i>=0;--i)
     {
         System.out.print(a[i]);
     }
 }