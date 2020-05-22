static Character.UnicodeScript getScript(String s) {
    int[] counts = new int[Character.UnicodeScript.values().length];

    Character.UnicodeScript mostFrequentScript = null;
    int maxCount = 0;

    int n = s.codePointCount(0, s.length());
    for (int i = 0; i < n; i = s.offsetByCodePoints(i, 1)) {
        int codePoint = s.codePointAt(i);
        Character.UnicodeScript script = Character.UnicodeScript.of(codePoint);

        int count = ++counts[script.ordinal()];
        if (mostFrequentScript == null || count > maxCount) {
            maxCount = count;
            mostFrequentScript = script;
        }
    }

    return mostFrequentScript;
}