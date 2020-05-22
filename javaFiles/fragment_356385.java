public String getScoreLine( int maxLength ) {

    String format = "%-" + maxLength + "s %6d %6d";

    return String.format( format, getName(), getYahtzee(), getTotalscore() );
}