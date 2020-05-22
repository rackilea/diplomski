try{
    insert();
} catch(MyException me){
    addActionError(me.getMessage());
    return "anything_you_want";
}