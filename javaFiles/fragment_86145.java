StringBuilder sb = new StringBuilder();
if (tempDisplayText != null) {
    int firstFullStopIndex;
    while( tempDisplayText.length() > 400
       && 
       (firstFullStopIndex = tempDisplayText.indexOf(". ", 350)) >= 0 ){
    sb.append( "<p>" );
    sb.append( tempDisplayText.substring(0, firstFullStopIndex) );
    sb.append( ".</p>" );
    tempDisplayText = tempDisplayText.substring(firstFullStopIndex + 1);
    }
    if( tempDisplayText.length() > 0 ){
        sb.append( "<p>" ).append( tempDisplayText ).append( "</p>" );
    }
    tempDisplayText = sb.toString();
}