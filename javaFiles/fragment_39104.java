for(int j=i+1; j<nrecords; j++){

    if((gradeBook[index].studentId).compareTo(gradeBook[j].studentId) > 0){
            index = j;
    }

    Record temp =  gradeBook[i];
    gradeBook[i] = gradeBook[index];
    gradeBook[index] = temp;

}