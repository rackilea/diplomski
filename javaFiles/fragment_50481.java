private static boolean validatePW(String pw) {
    if(pw.length() == 6){
        int pwInt = Integer.MIN_VALUE;
        try{
            pwInt = Integer.parseInt(pw);
            char[] values = pw.toCharArray();
            boolean asc = true;
            boolean dec = true;
            int[] map = new int[10];
            map[values[0]-48] = 1;
            for(int i = 1; i < values.length; i++){
                asc = asc && values[i] - 1 == values[i-1];
                dec = dec && values[i] + 1 == values[i-1];
                map[values[i]-48] ++;
                if(map[values[i]-48] == 3){return false;}
            }
            if(asc || dec){
                return false;
            } else {
                return true;
            }
        } catch(NumberFormatException e){
            return false;
        }
    }
    return false;
}