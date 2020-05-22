public String printListLtr(List<Character> sb) {
    if (sb.size() == 0) 
        return "[]";
    StringBuilder b = new StringBuilder('[');
    for (Character c : sb) {
        b.append('\u200e').append(c).append(',').append(' '); 
    }
    return b.substring(0, b.length() - 2) + "]";
}