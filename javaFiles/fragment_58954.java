static Pattern SIZE_PATTERN=Pattern.compile("((\\d+)?X)?[LS]|M", Pattern.CASE_INSENSITIVE);
static int numerical(String size) {
    Matcher m = SIZE_PATTERN.matcher(size);
    if(!m.matches()) throw new IllegalArgumentException(size);
    char c = size.charAt(m.end()-1);
    int n = c == 'S'? -1: c == 'L'? 1: 0;
    if(m.start(1)>=0) n *= 2;
    if(m.start(2)>=0) n *= Integer.parseInt(m.group(2));
    return n;
}