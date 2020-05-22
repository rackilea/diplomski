private final Set<String> vocale = new HashSet<String>();
private final Set<String> consoane  = new HashSet<String>();

private init(){
    // fill the sets with your strings
}

private boolean isVocale(String s){
    return vocale.contains( s );
}

private boolean isConsoane(String s){
    return consoane.contains( s );
}