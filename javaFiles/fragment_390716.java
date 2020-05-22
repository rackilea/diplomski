private static void weatherForecast() {

    String[] keys = {"Sunny Hot High False No", 
                     "Overcast Hot High False Yes", 
                     "Rainy Mild High False Yes"};

    Map<String, Integer> map = new HashMap<String, Integer>();

    for (String key : keys) {
        String[] split = key.split(" ");
        //Assume your data set is consistent with the 'classLabel' 
        //always the last field.
        String classLabel = split[split.length-1];

        if (map.containsKey(classLabel)) {
            map.put(classLabel, map.get(classLabel) + 1);
        } else {
            map.put(classLabel, 1);
        }
    }

    for (String string : map.keySet()) {
        System.out.println(string + ": " + map.get(string));
    }    
}