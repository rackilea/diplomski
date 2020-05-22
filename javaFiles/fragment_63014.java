public static String formatString(final String stringToFormat,final Object... args)
  {
  if(stringToFormat==null||stringToFormat.length()==0)
    return stringToFormat;
  int specifiersCount=0;
  final int argsCount=args==null ? 0 : args.length;
  final StringBuilder sb=new StringBuilder(stringToFormat.length());
  for(int i=0;i<stringToFormat.length();++i)
    {
    char c=stringToFormat.charAt(i);
    if(c!='%')
      sb.append(c);
    else
      {
      final char nextChar=stringToFormat.charAt(i+1);
      if(nextChar=='%'||nextChar=='n')
        {
        ++i;
        sb.append(c);
        sb.append(nextChar);
        continue;
        }
      // found a specifier
      ++specifiersCount;
      if(specifiersCount<=argsCount)
        sb.append(c);
      else while(true)
        {
        ++i;
        c=stringToFormat.charAt(i);
        // find the end of the converter, to ignore it all
        if(c=='t'||c=='T')
          {
          // time prefix and then a character, so skip it
          ++i;
          break;
          }
        if(c>='a'&&c<='z'||c>='A'&&c<='Z')
          break;
        }
      }
    }
  return String.format(sb.toString(),args);
  }