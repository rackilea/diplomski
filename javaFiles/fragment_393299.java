public double average(){
    int chap = 8;
    double sum = 0;
    for(int i = 0; i<grades.length; i++)
        sum+=grades[i];
    double average = sum / chap;

    return average;   
}
public double lowChap(){    
    double minValue = grades[0];

    for(int i=0;i<grades.length;i++){
        if(grades[i] < minValue)
           minValue = grades[i];
    }
    return minValue;
}