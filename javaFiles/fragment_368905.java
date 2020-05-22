private static boolean fullyCovered(final String input,
    final Pattern pattern)
{
    // If the string is empty, check that it is matched by the pattern
    if (input.isEmpty())
        return pattern.matcher(input).find();

    final int len = input.length();
    // All initialized to false by default
    final boolean[] covered = new boolean[len];

    final Matcher matcher = pattern.matcher(input);

    for (int index = 0; index < len; index++) {
        // Try and match at this index:
        if (!matcher.find(index)) {
            // if there isn't a match, check if this character is already covered;
            // if no, it's a failure
            if (!covered[index])
                return false;
            // Otherwise, continue
            continue;
        }
        // If the match starts at the string index, fill the covered array
        if (matcher.start() == index)
            setCovered(covered, index, matcher.end());
    }

    // We have finished parsing the string: it is fully covered.
    return true;
}

private static void setCovered(final boolean[] covered,
    final int beginIndex, final int endIndex)
{
    for (int i = beginIndex; i < endIndex; i++)
        covered[i] = true;
}