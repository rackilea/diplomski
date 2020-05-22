private final Scanner scanner;
private final String delimiter =  "\\*|/|-|\\(|\\)|";

private final Pattern delim  = Pattern.compile(delimiter);
private Matcher delim_matcher;

private String  region;
private int     regionStart;
private int     regionEnd;
private int     start;
private int     end;

// Called by constructor, I stripped the constructor because trivial
private void Init(){
    scanner = new Scanner(System.in);
    region = scanner.next();
    delim_matcher = delim.matcher(region);
    regionStart = 0;
    regionEnd = region.length();
}

private boolean nextDelimiter(){
    boolean found = delim_matcher.find();
    start = found ? delim_matcher.start() : delim_matcher.regionEnd();
    end = found? delim_matcher.end(): delim_matcher.regionEnd();
    return found;
}

private boolean hasPrefix(){
    return start > regionStart;
}

public TokenType next() throws NoSuchElementException{
    //find next delimiter ( symbol )
    boolean found = nextDelimiter(); //TODO: see breakpoints here

    if(hasPrefix()){

        //there was something before the delimiter (keyword, identificator etc.)
        decodePrefix( region.substring(regionStart,start) );

        if(found)
            delim_matcher.region(start,regionEnd); //reset to match symbol next time

        regionStart = start; //hasPrefix -> false
        return tokenType;   
    }
    else if(!hasPrefix() && found){

        decodeSymbol( region.substring(start,end)); 
        delim_matcher.region(end,regionEnd); //reset to skip already found symbol
        regionStart = end;
        return tokenType;
    }
    else{

        if(scanner.hasNext()){ //next is not a whitespace (because scanner already skip blanks)
            region = scanner.next(); 
            delim_matcher = delim.matcher(region);
            regionStart = 0;
            regionEnd = region.length();
            return next();
        }else
            return tokenType = EOF;
    }
}

public boolean hasNext() {
    return tokenType != EOF; //EOF is a value of the enum "TokenType"
}