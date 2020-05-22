static int solve(String sample){    
        int len=sample.length();
        char[] letters = sample.toCharArray();
        int sim=0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(letters[j-i]==letters[j])
                    sim++;
                else
                    break;
            }
        }
    return sim;
}