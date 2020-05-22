List<Map<String, String>> test = new ArrayList<Map<String, String>>();
        for( Map<String, String> map : test ){
            for( Entry<String, String> entry : map.entrySet() ){
                System.out.println( entry.getKey() + " : " + entry.getValue() );
            }
        }