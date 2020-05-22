for (DateFormat candidate : formats) {
    if (isValid(candidate, criteria)) {
        // whatever
    }
}

...
private static boolean isValid(DateFormat format, Criteria criteria) {
    return format.parse(criteria.getPeriodFrom(), new ParsePosition(0)) != null &&
           format.parse(criteria.getPeriodTo(), new ParsePosition(0)) != null))
}