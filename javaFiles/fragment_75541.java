VelocityContext context = new VelocityContext();
context.put("param", paramMap);
context.put("placeList", placeList);
StringWriter writer = new StringWriter();
ve.evaluate(context, writer, "", template);
return writer.toString();