int sum = 0;
for(int i =0; i < matrix.length){
 for(int j = 0; j < matrix[i].length; j++){
   sum += matrix[i][j];
 }
}
return sum;