@EJB B b;
public Result process(final List<String> input) {
final Result status = createStatus(input)
Future<SomeResult>result= b.performBigTask(input);
//check if every thing went well or what ever logic you have 
return status;
}