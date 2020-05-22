final String script = "1+x";
try
{
  final Map<String, Object> ctx = new HashMap<String, Object>();
  ctx.put("x", 5);
  final Binding binding = new Binding(ctx);
  final Object result = new GroovyShell(binding).evaluate(script);
  System.out.println(result);
}
catch (final GroovyRuntimeException e)
{
  // something bad happend - e.g. script error
  e.printStackTrace();
}