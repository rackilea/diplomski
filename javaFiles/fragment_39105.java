private void sortById(){

    //Selection Sort

    for(int i=0; i<nrecords-1; i++){

        int index = i;

        for(int j=i+1; j<nrecords; j++){

            if((gradeBook[index].studentId).compareTo(gradeBook[j].studentId) > 0){

                index = j;

            }

            Record temp =  gradeBook[i];
            gradeBook[i] = gradeBook[index];
            gradeBook[index] = temp;

        }

    }

}