String x = "exampleString";
StringBuilder buf = new StringBuilder(x);
for (int i = 0; i < buf.length(); i++)
{
    switch (buf.charAt(i))
    {
    case 'e':
        buf.setCharAt(i, 'a');
        break;
    case 'a':
        buf.setCharAt(i, 'b');
        break;
    }
}
System.out.println(buf.toString());