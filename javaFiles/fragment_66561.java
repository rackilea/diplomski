class Hello    
{
public static void main(String[] args)
{
   int tal2;
   int tal3 =0;
   int tal4 =0;
for (int i=0; i<1; i=i+1){
tal2 = 1 +(int)(Math.random () * ((9)));
System.out.print("" + tal2);
}
for (int i=0; i<1; i=i+1){
tal3 = 1 +(int)(Math.random () * ((1)));
System.out.print("\n" + tal3);
}
if (tal3==1){
for (int i=0; i<1; i=i+1){
 tal4 = 1 +(int)(Math.random () * ((2)));
System.out.print("\n" + tal4);
}
}
else if (tal3==0)
for (int i=0; i<1; i=i+1){
 tal4 = 1 +(int)(Math.random () * ((9)));
System.out.print("\n" + tal4);

}
}
}