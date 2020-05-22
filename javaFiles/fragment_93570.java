private final String ENCODED_PART_REGEX_PATTERN="=\\?([^?]+)\\?([^?]+)\\?([^?]+)\\?=";

private String decode(String s)
{
    Pattern pattern=Pattern.compile(ENCODED_PART_REGEX_PATTERN);

    Matcher m=pattern.matcher(s);

    ArrayList<String> encodedParts=new ArrayList<String>();

    while(m.find())
    {
        encodedParts.add(m.group(0));

    }

    if(encodedParts.size()>0)
    {
        try
        {
            for(String encoded:encodedParts)
            {
                s=s.replace(encoded, MimeUtility.decodeText(encoded));
            }

            return s;

        } catch(Exception ex)
        {
            return s;
        }
    }
    else
        return s;

}