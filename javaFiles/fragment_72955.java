String source = "Alpha,Beta,Gama,\"23-5-2013,TOM\",TOTO,\"Julie, KameL\n"
              + "Titi\",God,\" timmy, tomy,tony,\n"
              + "tini\".";

Pattern p = Pattern.compile("(([^\"][^,]*)|\"([^\"]*)\"),?");
Matcher m = p.matcher(source);

while(m.find())
{
    if(m.group(2) != null)
        System.out.println( m.group(2).replace("\n", "") );
    else if(m.group(3) != null)
        System.out.println( m.group(3).replace("\n", "") );
}