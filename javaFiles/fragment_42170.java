void getDeleteFile(){
    for (int i = 0;i < utils.myPosTitle.size();i++){
        String thisFile = utils.myPosTitle.get(i).toString();
        deleteFile(thisFile);
    }
}