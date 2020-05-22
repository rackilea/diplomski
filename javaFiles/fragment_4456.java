for (MatchRange range : ranges) {
    //...
    // This is where I would have a rule formatter
    String match = text.substring(range.getStart(), range.getEnd());
    for (ConditionFormatter formatter : formatters) {
        if (formatter.matches(match)) {
            sb.append(formatter.applyFormatTo(match));
            break;
        }
    }
    //...
}