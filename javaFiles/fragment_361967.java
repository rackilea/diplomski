public void myCode(Context context){
    int sPSavedData = getData(context);
    if(sPSavedData != 0){
        saveData(context, sPSavedData++);
    }
}