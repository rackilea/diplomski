String res = "";
    public String altPairs(String str) {
        int i=0;
        while (i<str.length()) {
            res +=str.charAt(i);
            i=i+1;
            if(i<str.length()) {
                res+=str.charAt(i);
                i=i+3;
            }
        }
        return res;
    }