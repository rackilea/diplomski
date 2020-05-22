String[] tokens = "abc243gca87asas**78sassnb32snb1ss22220220".split("\\d+");
for(String token : tokens){
    System.out.println(token);
}

public static Iterable<String> splitByRegex(String string, String regex){
    return Splitter.onPattern(regex).trimResults().omitEmptyStrings().split(string);
}