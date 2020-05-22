public double integration(double a , double b) {
     polynomial integral= new polynomial (this.degree+1);
     integral.degree= this.degree+1;
     for (int i=0 ; i<= this.degree+1 ; i++){
         if (i==0) {
             integral.coefficients[i]= 0;
         }
         else {
            integral.coefficients[i]= (this.coefficients[i-1]/i); 

         }
         }
     return (this.evaluate(b)- this.evaluate(a));
 }