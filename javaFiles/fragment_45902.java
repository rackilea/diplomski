main: for (int s=0; s < str.length(); s++){
    char ch_str = str.charAt(s);
    for ( int i = 0; i < conlenth ; i++){
        char ch_cons = consonants[i];
        if (ch_str == ch_cons){
            sum_ind += s;
            System.out.println( "cons. = " + ch_cons + " index = " + s );
            continue main;
        }
    }
}