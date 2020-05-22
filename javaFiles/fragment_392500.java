public class ParameterExtractor extends ValueExtractor<Set<Parameter>, String> {
   @Override
   public void extract( Set<Parameter> parameters, String parameterName, ValueCollector collector ) {
      for ( Parameter p : parameters ) {
          if ( parameterName.equals( p.getName() ) ) {
              collector.addObject( p.getValue() );
          }
      }
   }
}