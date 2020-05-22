public void editStatsName(int leadPosition){
int leadNewPos = leadPosition;
int buttonNumber = getButtonList.size();
int couterNew = 0;
for(int i=0;i<buttonNumber;i++){
    if(couterNew == leadNewPos){
        getButtonList.get(i).click();           
        break;
    }else{
        couterNew++;
    }
}