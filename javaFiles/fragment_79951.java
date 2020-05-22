int marks_60_70 = 0;
int marks_70_80 = 0;
int marks_80 = 0;  

for(int mark: marks) {
    if((mark >= 60) && (mark < 70)) {
        marks_60_70++;
    } else if ((mark >= 70) && (mark < 80)) {
        marks_70_80++;
    } else if(mark >= 80) {
        marks_80++;
    }
}