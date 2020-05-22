HashMap objH=new HashMap<>();
Set objSet=objH.keySet();
public static LegendaryItem getClass(UUID uniqueId) {
    Iterator objItr=objSet.iterator();
    while(objItr.hasNext()){
        UUID objStr=(UUID) objItr.next();
        if(objStr.equals(uniqueId)){
            return objStr;
        }
    }
}