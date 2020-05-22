@Column
String s1;

@Column
String s2;

public String[] getProp()
{
  return new String[]{ s1, s2 };
}

public String setProp(String[] s )
{
   s1 = s[0];
   s2 = s[1];
}