private boolean findPatternInBuffer(Pattern pattern, int horizon) {
    // omitted: calculating search limit

    matcher.region(position, searchLimit);

    // omitted: matching pattern
}