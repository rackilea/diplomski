void multiply(int num1,int num2)  
{
int counter=0;  
if(num1<0)  
{counter++;num1+=num1+num1;}  
if(num2<0)  
{counter++;num2+=num2+num2;}    
double res=Math.log(num1)+Math.log(num2);  
int result=(int)Math.exp(res);
if(counter%2==0)
System.out.println("the result is:"+result);
else
System.out.println("the result is:-"+result);  
}