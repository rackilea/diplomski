String[] evenodd = {" number is even", " number is odd"};
for(int i = 0; i < 100; i++)
{
int x;

if(i%2==0){
 x=0;/*pass 0 to print even number */
}else{
 x=1;/*pass 1 to print odd number*/
}
System.out.println(i + evenodd[x]);
}