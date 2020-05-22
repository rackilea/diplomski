private static String convertToLetterGrade(double grade){
        String letterGrade="";
        if(grade == 4.0){
            letterGrade="A";
        }else if(grade >=3.5 && grade < 4){
            letterGrade="A/B";
        }else if(grade >= 3.0 && grade < 3.5){
            letterGrade="B";
        }else if(grade >= 2.5 && grade < 3.0){
            letterGrade="B/C";
        }else if(grade >= 2.0 && grade < 2.5){
            letterGrade="C";
        }else if(grade >= 1.0 && grade < 2.0){
            letterGrade="D";
        }else if(grade < 1.0){
            letterGrade="F";
        }
        return letterGrade;
 }