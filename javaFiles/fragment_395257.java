public static String[][] compress(String[][] sArray){
    for(String s[] : sArray){
        int current = 0;
        while(current <= s.length){
            int sequentials = 1;
            while(s[current].equals(s[current+sequentials])){
                s[current+sequentials] = "";
                sequentials++;
                if(current+sequentials>s.length) 
                    break;
            }
            if(sequentials > 1) s[current] = sequentials+"*"+s[current];
            current++;
        }
    }   
    return sArray;
}