ArrayList <String> parsed = new ArrayList <String> ();

for (int x = 0; x < size; x++) {
    String line = list.get(x);

    if (startsWith(line, '[')) {
        parsed.add(line);
    } else {
        int lastn = parsed.size() - 1;
        String last = parsed.get(lastn);
        last += "\\n" + line;
        parsed.set(lastn, last);
    }
}