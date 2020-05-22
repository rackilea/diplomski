public int getLastNumDifThenZero(String text){
    char[] ca = text.toCharArray();
    for (int i = ca.length-1; i >= 0; i--) {
        char a = ca[i];
        try {
            int n = Integer.parseInt(String.valueOf(a));
            if (n!=0){
                return n;
            }
        } catch (NumberFormatException e) {
            //Not a number
        }

    }
    return -1;
}