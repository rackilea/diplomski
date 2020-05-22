LinkedHashSet<string> printNum = new LinkedHashSet<string>();
if(niz[i] == niz2[j])
{
      printNum.add( niz[i] );
}

// outside of loop
for( string s : printNum )
{
      System.out.println(s);
}