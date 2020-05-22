for (Pair<ConferenceInfo, ConferenceInfo> result : results) {
    ConferenceInfo first = result.getFirst();
    ConferenceInfo second = result.getSecond();
    if (!field.areEqual(first, second)) {
        differentValues++;
    }
}