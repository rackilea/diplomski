public Set<String> performCollect() {
    for (String number : numbers) {
        if (isNumberMatches(number)) {
            result.add(number);
        }
    }

    return result;
}

protected boolean isNumberMatches(String number) {
    NumberMatcher nm = new NumberMatcher(number, offset);
    for (NumberPattern pattern : patterns) {
        if (nm.processMatch(pattern)) {
            return true;
        }
    }
    return false;
}