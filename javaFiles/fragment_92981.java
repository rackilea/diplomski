public boolean checked(){

    /*this code loops through all comboboxes, checks they are not default 
     * and adds 1 to i. if i is 6, by the end of then it means that none
     * are default and true is returned
     */
    int i = 0;
    if(drop1.getSelectedIndex() != 0){
        i++;    
    }
    if(drop2.getSelectedIndex() != 0){
        i++;   
    }
    if(drop3.getSelectedIndex() != 0){
        i++;
    }
    if(drop4.getSelectedIndex() != 0){
        i++;
    }
    if(drop5.getSelectedIndex() != 0){
        i++;
    }
    if(drop6.getSelectedIndex() != 0){
        i++;
    }

    if(i == 6){
        return true;
    }else{
        return false;
    }

}