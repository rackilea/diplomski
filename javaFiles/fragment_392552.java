String text="Federation of AP Chambers of Commerce &amp; Industry Awards for the year 2010-11. Speaking on the occasion, 
He said, &quot;About 54 percent of the population is youth aged below 25 years. We have to use their energy and 
intelligence for development of the state as well as the country.The youth trained will also be absorbed by 
companies.&rsquo;&quot";

    text= replaceAll(text,"&quot;","\"");

    text= replaceAll(text,"&amp;","&");

    text= replaceAll(text,"&rsquo;","’");




private String replaceAll(String source, String pattern, String replacement) {
        if (source == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int index;
        int patIndex = 0;
        while ((index = source.indexOf(pattern, patIndex)) != -1) {
            sb.append(source.substring(patIndex, index));
            sb.append(replacement);
            patIndex = index + pattern.length();
        }
        sb.append(source.substring(patIndex));
        return sb.toString();
    }