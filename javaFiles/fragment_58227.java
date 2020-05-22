Iterator    it;
Map         params;
String      name;
String[]    values;
int         n;

params = request.getParameterMap();
it = params.keySet().iterator();
while (it.hasNext())
{
    name = (String)it.next();
    values = (String[])params.get(name);
    for (n = 0; n < values.length; ++n)
    {
        // ...use value[n]...
    }
}