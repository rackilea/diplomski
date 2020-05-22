public int anotherMethod(){
    return intVar--;
}

public void actionPerformed(ActionEvent e) {
    if (someCondition){
        clickedButton.setVisible(false);
        if (anotherMethod()==0){
            //Do something
        }
    }
}