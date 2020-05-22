List<Map<String, Object>> test = new ArrayList<Map<String, Object>>();
        for( Map<String, Object> map : test ){
            for( Entry<String, Object> entry : map.entrySet() ){
                if( entry.getKey().equalsIgnoreCase( "capabilities" ) ){
                    List<String> myCapabilities = ( List )entry.getValue();
                    if( myCapabilities.contains( "dog" ) && myCapabilities.contains( "cat" ) ){
                        // BLA BLA
                    }
                }
            }
        }