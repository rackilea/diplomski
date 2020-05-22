private void printAverageMinAndMax(double[] grades){
    double total = 0.0;
    double max = 0.0;
    double min = Double.MAX_VALUE;
    //Loop through all of the grades.
    for(int i = 0; i < 100; i++){
        double grade = grades[i];
        //Add the grade to the total
        total += grade;
        //If this is the highest grade we've encountered, set as the max.
        if(max < grade){
            max = grade;
        }
        //If this is the lowest grade we've encountered, set as min.
        if(min > grade){
            min = grade;
        }
    }

    System.out.println("Average is: " + (total / 100));
    System.out.println("Max is: " + max);
    System.out.println("Min is: " + min);
}