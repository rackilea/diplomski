@Override
public void beforeRequest(Map<String,List<String>> headers)
{
    List<String> values = new ArrayList<String>();
    values.add("My Value");

    headers.put("X-My-Custom-Header", values);
}