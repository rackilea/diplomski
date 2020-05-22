import add.*; // import statements should be at top after package outside 
public class test{
public static void main (String[] args){
int x;
addTogether testObj=new addTogether();
int result=testObj.add(4,5);
System.out.println("Result: "+result);
}}


public class AddTogether{
public void addtogether(int a, int b){
return a+b; // your method has no return statement
}}