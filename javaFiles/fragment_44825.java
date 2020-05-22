public String generatClue(String answer,int level){
    if(level >= answer.length()/2)
        return answer.replaceAll("[^ ]","*");

    return answer.substring(0,level)
      + answer.substring(level,answer.length()-level).replaceAll("[^ ]","*")
      + answer.substring(answer.length()-level);
}