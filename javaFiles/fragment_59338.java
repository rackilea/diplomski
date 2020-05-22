for (int i = 0;i<numStudents;i++){
    if (grades[i]>0 && grades[i]<=100){
       sum += grades[i];
    }
    else
       System.out.println("invalid grade, Try again later");
}