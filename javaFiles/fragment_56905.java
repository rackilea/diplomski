public static void main(String[] args) throws Exception {

    List<String> signatureList = new ArrayList<String>();
    signatureList.add("Test");
    signatureList.add("asdf");
    signatureList.add("jkjk");
    signatureList.add("Test");
    signatureList.add("1231");
    signatureList.add("asdf");
    signatureList.add("Test");

    Map<String,List<Integer>> locations = new HashMap<String,List<Integer>>();

    for (int i = 0; i < signatureList.size(); i++) { 
        boolean unique = true;

        for (int j = 0; j < signatureList.size(); j++) {

            if (i == j) {
                continue;
            }

            if (signatureList.get(i).equals(signatureList.get(j))) {
                unique = false;
                break;
            }

        }

        if (!unique) {

            if(locations.containsKey(signatureList.get(i))){
                List<Integer> intLocations = locations.get(signatureList.get(i));
                intLocations.add(i);
                locations.put(signatureList.get(i), intLocations);
            }else{
                List<Integer> intLocations = new ArrayList<Integer>();
                intLocations.add(i);
                locations.put(signatureList.get(i), intLocations);
            }
        }
    }

    for(Entry<String,List<Integer>> en : locations.entrySet()){
        System.out.print(en.getKey() + " : ");
        for(Integer i : en.getValue()){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}