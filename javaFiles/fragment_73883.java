for(int i = 0; i < exams; i++){
    totalExam += Integer.parseInt(examScores[i]);
    if(Integer.parseInt(examScores[i]) < lowest){
    lowest = Integer.parseInt(examScores[i]);
    }
    if(Integer.parseInt(examScores[i]) > highest){
    highest = Integer.parseInt(examScores[i]);
    }
}