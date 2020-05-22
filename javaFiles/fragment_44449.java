public class NewClass4{
 public static HashMap<String, ArrayList<String>> CountryMap = new HashMap<String, ArrayList<String>>();
    public static void main(String[] args)
    {
        ArrayList<String> stateInd = new ArrayList<String>();
        ArrayList<String> stateUSA = new ArrayList<String>();
        stateInd.add("GJ");
        stateInd.add("MP");
        stateUSA.add("NJ");
        stateUSA.add("NY");

        CountryMap.put("India",stateInd);            
        CountryMap.put("USA",stateUSA);

        ArrayList<String> result = new ArrayList<String>();
        result=CountryMap.get("India");
        if(result!=null){
            // means CountryMap contain key "India"
        }
    }
}