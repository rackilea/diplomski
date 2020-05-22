public static String mostCommon(ArrayList<Pair> pairs){
    Pair max = new Pair(0,"");
    String result = "";
    for(Pair pair : pairs){
        if(pair.getRepetitions() > max.getRepetitions()){
            result = pair.getSentence();
            max = pair;
        }else if(pair.getRepetitions()==max.getRepetitions()){
            result += "; " + pair.getSentence();
        }
    }
    return result;
}