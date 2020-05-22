int sum1=0;
int sum2=0; 
for (int i=1; i<6; i++){
double val = Math.random();    
if(val<0.5){
     sum1++;
 }else {
     sum2++;
    }
     System.out.println("sum of head "+sum1);
     System.out.println("sum of tail "+sum2);    
 }