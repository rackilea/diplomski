public String generatClue2(String answer,int level){
    if(answer.length()==level)
        return answer.replaceAll("[^ ]","*");

    Random rand=new Random();

    for(int i=0; i<level; ++i){
        char c;
        int n;
        do{
            n=rand.nextInt(answer.length());
            c=answer.charAt(n);
        }
        while(c == ' ' || c == '*');
        answer = answer.substring(0,n) + '*' + answer.substring(n+1);
    }
    return answer;
}