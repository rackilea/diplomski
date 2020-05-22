/**
 * This method ensures that the output String has only
 * @param in the string that has a non valid character.
 * @return the string that is stripped of the non-valid character
 */
private String stripNonValidXMLCharacters(String in) {      
    if (in == null || ("".equals(in))) return null;
    StringBuffer out = new StringBuffer(in);
    for (int i = 0; i < out.length(); i++) {
        if(out.charAt(i) == 0x1a) {
            out.setCharAt(i, '-');
        }
    }
    return out.toString();
}