double x [][] = {{3.24,-0.96},
                 {-1.56,-0.61},
                 {-1.1,2.5},
                 {1.36,-4.8}};
String y [] = {"B","C","A","C"};
double w[][] = {{0,1.94,3.82},{0,-4.9,-4.03},{0,4.48,3.25}};
double threshold = 1;
int n = x.length;
int m = w.length;
double total [] = new double[3];
double max = Integer.MIN_VALUE;
double input = 0;

for(int i=0;i<n;i++){
     for(int j=0;j<m;j++){
     total[j] = (threshold * w[j][0]) + (x[i][0] * w[j][1]) + (x[i][1] * w[j][2]);
      System.out.print(total[j] +", ");

input = total[j];
max = Math.max(input,max);
}

System.out.println();
System.out.println("Maximum is "+ max);
 max = Integer.MIN_VALUE;
}