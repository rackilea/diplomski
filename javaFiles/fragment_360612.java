double[] a1 = {1.2, 2.3, 3.4, 4.5, 5.6};

double[] a2 = {1.0, 2.0, 3.0, 4.0, 5.0}; 

double [] a3 = new double[5];


for(int i=0; i < a1.length; i++){
    a3[i] = a1[i] + a2[i];
}
for(int i=0; i < a1.length; i++){
    System.out.println(a3[i]);  
}