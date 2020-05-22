public class ListValueExtractor extends ValueExtractor<List<String>, String> implements Serializable {

    @Override
    public void extract( List<String> listValues, String argument, ValueCollector collector ) {
        if ( "any".equals( argument ) ) {
            for ( String v : listValues ) {
                collector.addObject( v );
            }
        }
    }
}