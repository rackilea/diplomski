public boolean equals(Object o){
        if(this == null){
            return false;
        }
        if(this == o){
            return true;
        }
        if(!(o instanceof Employee)){
           return false;
        }
        //set all the elements in the array to false and change to true when true.
        boolean [] doesItMatch = new boolean[4];
        doesItMatch[0] = false;
        doesItMatch[1] = false;
        doesItMatch[2] = false;
        doesItMatch[3] = false;

        Employee temp = (Employee) o;
        if(this.getEmployeeName().equals(temp.getEmployeeName())){
            doesItMatch[0] = true;
        }
        if(this.getEmployeeNumber().equals(temp.getEmployeeNumber())){
            doesItMatch[1] = true;
        }
        if(this.gethireyear() == temp.gethireyear()){
            doesItMatch[2] = true;
        }
        if(this.getWeeklyEarning() == temp.getWeeklyEarning()){
            doesItMatch[3] = true;
        }
        int check = 0;
        //Now that you have checked all the values, check the array. Using a simple counter. 
        for(int i = 0; i < doesItMatch.length; i++){
            if(doesItMatch[i]){
                check++;
            } else {
                check--;
            }
        }
        //The counter should be 4 when the if statements above are all true. Anything else is false.
        if(check == 4){
            return true;
        } else {
            return false;
        }
    }