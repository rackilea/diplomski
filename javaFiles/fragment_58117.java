public String findWithinHorizon(Pattern pattern, int horizon) {
    // omitted: validate parameters

    while (true) {
        if (findPatternInBuffer(pattern, horizon)) {
            matchValid = true;
            return matcher.group();
        }

        // omitted: check if more input is required
    }
    return null;
}