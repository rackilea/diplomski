public double integration(double a , double b) {
     polynomial integral= new polynomial (degree+1);
     integral.degree= degree+1;
     for (int i=0 ; i<= degree+1 ; i++){
         if (i==0) {
             integral.coefficients[i]= 0;
         }
         else {
         integral.coefficients[i]= (coefficients[i-1]/i); 

         }
         }
     return (evaluate(b)- evaluate(a));
 }