public int anotherMethod(){
    return --intVar;
}

public void actionPerformed(ActionEvent e) {
    if (someCondition){
        clickedButton.setVisible(false);
        anotherMethod();
        if (intVar==0){
            //Do something
        }
    }
}