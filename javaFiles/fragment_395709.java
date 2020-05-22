public String changeFormat(String myString) {
    String[] lines = myString.split("-[-]+"); // split everytime there are two or more '-'
    StringBuffer sb = new StringBuffer(myString.length());
    for (String line in lines) {
        sb.append(line);
        sb.append('\n');
        sb.append("-----------------------------");
        sb.append('\n');
    }
    return sb.toString()
}