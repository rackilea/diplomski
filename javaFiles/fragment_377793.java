import java.util.Random;
class FirstClass{
 public static Object[][] firstMethod(){
   Random random=new Random();
   int a=random.nextInt(100);
   int b=random.nextInt(100);
   int n=0;
   Object[][] arrayObj=new Object[a][b];
   for(int i=0;i<a;i++)
     for(int j=0;j<b;j++){
        arrayObj[i][j]=++n;
     }
     return arrayObj;
  }
}
class SecondClass{
 public void secondMethod(){
   Object[][] myObj=FirstClass.firstMethod();
    System.out.println(myObj.length);      // length of row
    System.out.println(myObj[0].length);  //length of first column
    System.out.println(java.util.Arrays.deepToString(myObj));  //will print 2d array

 }
 public static void main (String[] args){
 new SecondClass().secondMethod();
 }
}