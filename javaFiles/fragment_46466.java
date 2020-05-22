import java.util.*;
class Number
{
 int fact(int n){
 int p=1;
 for(int i=1;i<=n;i++){
 p*=i;
 }
 return p;
 }
 public static void main(String args[]){
 Scanner sc=new Scanner(System.in);
 Number num=new Number();
 int number;
 System.out.println("Enter the limit:-");
 number=sc.nextInt();
 double sum=0;
 for(int lo=1;lo<=number;lo++){
 sum+=(double)lo/(double)(num.fact(lo));
 }
 System.out.println("The sum is:- "+sum);
 }
 }