StringBuilder sb = new StringBuilder ();
for (String s: new String [] {city, state, country})
{
    if (!s.isEmpty ())
    {
        if (sb.length () > 0) sb.append (",");
        sb.append (s);
    }
}
System.out.println (sb);