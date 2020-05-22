Grade[] studentGrades = new Grade[32];

public void populateArray(Grade[] list){
        for(int index = 0; index < list.length; index++){
            // grade here should call the default construcor of the grade class
            list[index] = new Grade();
        } //end of for loop
    } //end of populateArray