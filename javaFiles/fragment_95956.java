TimeUtil:
 public static String getLoginTableSuffix(){
    if(DateTime.now().getMonthOfYear()<10){
        return DateTime.now().getYear()+"_0"+DateTime.now().getMonthOfYear();
    }else{
        return DateTime.now().getYear()+"_"+DateTime.now().getMonthOfYear();
    }

}