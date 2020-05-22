public String getDisplayName(HashMap<String, String> givenHashMap, String givenProperty){

       String outputString = null;

       for(Map.Entry<String, String> pairs1 : givenHashMap.entrySet()){
           if(givenProperty.equals((String)pairs1.getKey())){
                outputString = pairs1.getValue();
            }
        }

       return outputString;
    }