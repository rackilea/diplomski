public static String join(Collection data, String delimiter) {
    final StringBuffer buffer = new StringBuffer();
    final Iterator iter = data.iterator();
    while (iter.hasNext()) {
        buffer.append(iter.next());
        if (iter.hasNext()) {
            buffer.append(delimiter);
        }
    }
    return buffer.toString();
}

// in your code:
join(personList, " or ");