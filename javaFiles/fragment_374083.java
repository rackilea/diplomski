int j=0;

float op1=0,op2=0,result=0;

Scanner inp=new Scanner(System.in);

 System.out.println("Sir,Please enter the expression");

 String exp1=inp.next();

 String exp = exp1.replaceAll("\\s","");    //It will replace all the spaces from the string

  for(int i=0;i<exp.length();i++){

     if(exp.charAt(i)=='+'||exp.charAt(i)=='-'||exp.charAt(i)=='*'||exp.charAt(i)=='/'){

       if(exp.charAt(i)=='+'){

               i=j;

               op1=Float.parseFloat(exp.substring(0, j+1));

               op2=Float.parseFloat(exp.substring(j+2,exp.length()));

               result=op1+op2;

               System.out.println(result);

               break;
         }

         if(exp.charAt(i)=='*'){

               i=j;

               op1=Float.parseFloat(exp.substring(0, j+1));

               op2=Float.parseFloat(exp.substring(j+2,exp.length()));

               result=op1*op2;

               System.out.println(result);

               break;

         }

         if(exp.charAt(i)=='-'){

               i=j;

               op1=Float.parseFloat(exp.substring(0, j+1));

               op2=Float.parseFloat(exp.substring(j+2,exp.length()));

               result=op1-op2;

               System.out.println(result);

               break;
         }

         if(exp.charAt(i)=='/'){

               i=j;

               op1=Float.parseFloat(exp.substring(0, j+1));

               op2=Float.parseFloat(exp.substring(j+2,exp.length()));

               if(op2==0){

                   System.err.println("Division by zero is not possible");

                   break;

               }

               else{

                  result=op1/op2;

                  System.out.println(result);

                  break; 
               }

         }
     }


 }