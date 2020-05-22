Matcher m = p.matcher(line);
if (m.matches() && m.groupCount() == 2) {
    name = m.group(1);
    price = getNumberRepresentation(m.group(2));
} else {
    // line doesn't match the pattern, handle the exception!
}