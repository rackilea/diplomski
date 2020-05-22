public double getAverage(){
        double average;
        double accum = 0;
        for(int x = 0; x < grades.length; x++){

            accum += grades[x].getScore();

        }
        average = accum/grades.length;
        return average;
    }