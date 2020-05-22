public void BMI1(){
     System.out.println("Enter the value of Height and Weight");
     Scanner input1=new Scanner(System.in);
     Height=input1.nextFloat();
     Weight=input1.nextFloat();
     BMI1=Weight/(Height*Height);
     System.out.println("The BMI value is :\t"+BMI1);
 }