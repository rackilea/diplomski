public class Field_1Extractor extends ValueExtractor<Set<MyObject>, String> {
    @Override
    public void extract(
            final Set<MyObject> target,
            final String argument,
            final ValueCollector collector ) {

            for ( final MyObject o : target ) {
                collector.addObject( o.getField_1() );
            }
    }
}