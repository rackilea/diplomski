for (int s=0; s < str.length(); s++){
    char ch_str = str.charAt(s);
    switch (ch_str){
        case 'b':
        case 'c':
        ...
        case 'z':
            sum_ind += s;
            System.out.println( "cons. = " + ch_cons + " index = " + s );
            break;
    }
}