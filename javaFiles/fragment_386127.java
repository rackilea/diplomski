public static void main (String[] args) 
    {
        String s = "AABC";
        long score = 0;
        for(int i = 0; i < s.length(); ++i)
        {
            score += s.charAt(i) - 'A' + 1;
            //Basically, you check every index of the string and convert
            //each character into its score and add them.
        }
        System.out.println(score);
    }