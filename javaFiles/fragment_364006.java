public void setAverage(ArrayList<GradeInfo> grades) {
double average = 0;
for(int i = 0; i < grades.size(); i++){
    average += grades.get(i);
}
average = average / grades.size();
this.average = average;
}