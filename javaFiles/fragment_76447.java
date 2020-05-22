if (cd1.category != cd2.category) {
    return Integer.compare(cd1.category, cd2.category);
} else if (cd1.category == 2) {    // 2 means they have valid dates
    return cd1.date.compareTo(cd2.date);
} else {        // ComparisonDates are in same category and dates aren't
                // meaningful
    return 0;   // so treat them as equal
}