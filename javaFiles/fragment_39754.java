for(int i=0; i<classesTaken.size(); i++){
    ClassTaken c = classesTaken.get(i);
    if(c.getCourseId().equals(courseID)){
        c.updateGrade(newLetterGrade);
    }
}