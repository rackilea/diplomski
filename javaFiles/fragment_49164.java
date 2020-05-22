public int getAverageGrade(){
    int averageGrade = 0;
    for(int grade : Grades){
        averageGrade = averageGrade + grade;
    }
    averageGrade = averageGrade/Grades.length;
    return averageGrade;
}