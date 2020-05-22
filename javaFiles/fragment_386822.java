public boolean doesNotWork( String regNumInput ){
    for(int i = 0; i < meterList.size(); i++){
        if(regNumInput.equals(meterList.get(i).getRegNum())){
            meterList.get(i).setWorkOrNot("No");
        }
    }
    return true;
}