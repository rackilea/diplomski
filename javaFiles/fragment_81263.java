String s = ...;

StringBuilder propertiesEncoded = new StringBuilder();
for (int i = 0; i < s.length(); i++)
{
    char c = s.charAt(i);
    if (c <= 0x7e) propertiesEncoded.append((char) c);
    else propertiesEncoded.append(String.format("\\u%04x", (int) c)); 
}
ByteArrayInputStream in = new ByteArrayInputStream(propertiesEncoded.toString().getBytes("ISO-8859-1"));