public class SampleFunction extends BaseOperation implements Function
{
     public void operate( FlowProcess flowProcess, FunctionCall functionCall )
     {
         TupleEntry argument = functionCall.getArguments();
         String regex = argument.getString( 0 );
         String argument = argument.getString( 1 );
         String parsed = someRegexOperation();

         Tuple result = new Tuple();
         result.add( parsed );
         functionCall.getOutputCollector().add( result );
     }
}