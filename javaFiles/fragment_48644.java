float getAverage(){
    float sum = 0;
    for (int i: courseMarks){
        sum +=i;
    }
    return sum/courseMarks.size();              
}