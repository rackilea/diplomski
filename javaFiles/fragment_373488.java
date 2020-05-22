public String roll(){
        StringBuilder sb = new StringBuilder();
        if (studentcount >= 1)  sb.append( s1.toString() ).append( "\n" );
        if (studentcount >= 2)  sb.append( s2.toString() ).append( "\n" );
        if (studentcount >= 3)  sb.append( s3.toString() ).append( "\n" );
        if (studentcount >= 4)  sb.append( s4.toString() ).append( "\n" );
        if (studentcount >= 5)  sb.append( s5.toString() ).append( "\n" );
        return sb.toString();
    }