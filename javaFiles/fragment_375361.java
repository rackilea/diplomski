private static Boolean  _isNoun(String pot) {
    if(pot.equals("NN") || pot.equals("NNS") || pot.equals("NNP") || pot.equals("NNPS")) return true;
    else return false;
}

private static Boolean _isAdjective(String pot){
    if(pot.equals("JJ") || pot.equals("JJR") || pot.equals("JJS")) return true;
    else return false;
}