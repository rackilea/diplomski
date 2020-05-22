Map<String, ProtocolNode> testMap = new HashMap<String, ProtocolNode>();

        for( Entry<String, ProtocolNode> entry : testMap.entrySet() ){
            if( entry.getKey().equals( "MYKEY" ) ){
                System.out.println( entry.getValue() );
            }
        }