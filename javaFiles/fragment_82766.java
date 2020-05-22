public String formatNum(){
    String valueAsString = Integer.toString(currentValue); 
    while(valueAsString.length()<3){
        valueAsString = '0' + valueAsString; 
    }
    char[] stringBuilding = new char[valueAsString.length()+(((valueAsString.length())-2)/3)+1];
    int valueAsStringPtr = valueAsString.length()-1; 
    int stringBuildingPtr = stringBuilding.length-1;
    while(stringBuildingPtr>=0){
        if(stringBuildingPtr==stringBuilding.length-3){
            stringBuilding[stringBuildingPtr--] = '.'; 
        } else if((stringBuilding.length-stringBuildingPtr-3)%4==0){
            stringBuilding[stringBuildingPtr--] = ','; 
        } else { 
            stringBuilding[stringBuildingPtr--] = valueAsString.charAt(valueAsStringPtr--);
        }
    }
    String returnVal = String.copyValueOf(stringBuilding);  
    return returnVal; 
}