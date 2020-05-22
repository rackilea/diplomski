protected void handleRemoveConfirm(int dialogType) {
    if(dialogType == DIALOG_REMOVE_PERSON){
        calc.removePerson();
    }else if(dialogType == DIALOG_REMOVE_CALC){
        removeCalc();
    }
}