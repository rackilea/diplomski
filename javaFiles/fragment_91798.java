for (String word1 : args) {
    int len = word1.length();
    for (int i = 0; i < len; i++) {
        char letter = word1.charAt(i);
        int counter=0;                            //here !
        for (String word2 : args ){
            if (word2.contains(""+letter))
                counter++;
        }
        System.out.print(letter+"="+counter+" ");
    }

}