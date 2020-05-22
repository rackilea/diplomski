public static String chargeThis(String CCData, Double AMT){

     CCNum = GetCCNum(CCData) ;
     boolean isValid = validateCC(ccData);
     if(isValid) return chargeCC(ccNum,AMT) else return rejectedTrans ;
}