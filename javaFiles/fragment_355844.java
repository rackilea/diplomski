ArrayList<CmisObject> toReturn = new ArrayList<CmisObject>(); 
for(int i = 0; i < yourArrayListOfCmisObjects.size(); i++){
    CmisObject obj = yourArrayListOfCmisObjects.get(i); 
    if(obj.getParam1() == param1 && obj.getParam2() == param2 && ... obj.getParam6() == param6){
       toReturn.add(obj); 
    }
}