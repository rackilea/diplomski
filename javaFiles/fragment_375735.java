.withDifferenceEvaluator(((comparison, outcome) -> {
    if (outcome == ComparisonResult.DIFFERENT && 
        comparison.getType() == ComparisonType.CHILD_NODELIST_SEQUENCE) {
           return ComparisonResult.EQUAL;
    }

    return outcome;
}))