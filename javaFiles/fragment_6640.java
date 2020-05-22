private static final Pattern PATTERN = Pattern.compile("\\d(\\d+)");

public static void main(String[] args) throws IOException {
    try (StreamEx<String> stream = StreamEx.ofLines(Paths.get("..."))) {
        List<Record> records =
            stream.groupRuns((s1, s2) -> getRecordPart(s2) > getRecordPart(s1))
                  .map(RecordFactory::createRecord)
                  .toList();
    }
}

private static final int getRecordPart(String str) {
    Matcher matcher = PATTERN.matcher(str);
    if (matcher.find()) {
        return Integer.parseInt(matcher.group(1));
    }
    return 1; // if the pattern didn't find anything, it means the record is on a single line
}