public String findInLine(Pattern pattern) {
    // omitted: validate parameters
    // omitted: ensure the internal buffer is large enough

    return findWithinHorizon(pattern, horizonForLine);
}