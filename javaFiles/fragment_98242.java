String replaceFirstFrom(String str, int from, String regex, String replacement)
{
    String prefix = str.substring(0, from);
    String rest = str.substring(from);
    rest = rest.replaceFirst(regex, replacement);
    return prefix+rest;
}

// or
s.substring(0,start) +  s.substring(start).replaceFirst(search, replace);