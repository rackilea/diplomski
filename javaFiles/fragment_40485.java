final Matcher m = Pattern.compile("^(.+) = https:\\/\\/(\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})$");
m.matcher(line);
final Map<String,String> map = new HashMap<String,String();       
if (m.matches())
{
   final String lh = m.group(1);
   final String ip = m.group(2);
   map.add(lh,ip);
}