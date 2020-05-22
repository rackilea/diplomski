Iterator<?> it = schemaJSON.getJSONObject("body").keys();

while(it.hasNext())
{
     String next = (String) it.next();
     ...