public class LineUsageData {

    Map<Integer, Usage> map = new HashMap<Integer, Usage>();
    int hash = 0;
    public void addObservation(Usage usage){
        hash = usage.getName().hashCode();
        System.out.println(hash);
        while((map.get(hash)) != null){
            if(map.get(hash).getName().equals(usage.name)){
                map.get(hash).count++;
                return;
            }else{
                hash++;
            }

        }
        map.put(hash, usage);
    }






    public String getMaxUsage(){
        String str = "";
        int tempHigh = 0;
        int high = 0;

    //for loop
        for(Integer key : map.keySet()){
            tempHigh = map.get(key).getCount();
            if(tempHigh > high){
                high = tempHigh;
                str = map.get(key).getName() + " " + map.get(key).getCount();
            }
        }

        return str;
    }


}