public static void main( String[] args ) {
        List<ResponseData> responseDataList = Arrays.asList(
            new ResponseData( 1, -1 ),  // changed null to -1 as null can't be a map key
            new ResponseData( 2, 1 ),
            new ResponseData( 3, 1 ),
            new ResponseData( 4, 1 ),
            new ResponseData( 5, 2 ),
            new ResponseData( 6, 2 ),
            new ResponseData( 7, 3 ),
            new ResponseData( 8, 3 ),
            new ResponseData( 9, 4 ),
            new ResponseData( 10, 4 ),
            new ResponseData( 11, 5 ),
            new ResponseData( 12, -1 ),
            new ResponseData( 13, 12 )
        );
        final Map<Integer, List<ResponseData>> map = responseDataList.stream()
                .collect( Collectors.groupingBy( o -> getLevel( responseDataList, o, 0 ) ) );
        System.out.println( map );
        // To convert the Map to a List of Lists:
        System.out.println( new ArrayList<>( map.values() ));
    }

    private static int getLevel(List<ResponseData> nodes, ResponseData responseData, int level) {
        if( responseData.parent == -1 ) {
            return level;
        } else {
            return getLevel( nodes, nodes.get( responseData.parent - 1 ), level + 1 );  // -1 to adjust index
        }
    }

    private static final class ResponseData {
        public int id;
        public int parent;

        public ResponseData( int id, int parent ) {
            this.id = id;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return String.format( "{id: %d, parent: %d}", id, parent );
        }
    }