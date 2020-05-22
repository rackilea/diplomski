public static double[][] computeCategoryAverages(double[][] scoreArray){
for(int i = 0; i < scoreArray.length; i++){
    double sum = 0;
    int numOfAssign = 0;
    double average=0.0;
    System.out.printf("The Average for category:%d:",i+1);
    for(int j = 1; j < scoreArray[i].length-1; j++){
       numOfAssign++;
       sum = sum + scoreArray[i][j];

      }
    double average = sum / numOfAssign;
    scoreArray[i][scoreArray[i].length-1] = average;  

}
return scoreArray;
}