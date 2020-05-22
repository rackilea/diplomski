public int compare(TemplateBean b1, TemplateBean b2) {

    // avoid null pointer exceptions
    if (b1 == null && b2 == null) return 0;
    if (b1 == null) return 1;
    if (b2 == null) return -1;

    int cmp = 0;
    if ("UNATTACHED".equals(b1.getStatusCode()) &&
       !"UNATTACHED".equals(b2.getStatusCode())) {
        cmp = 1;
    }
    if (!"UNATTACHED".equals(b1.getStatusCode()) &&
       "UNATTACHED".equals(b2.getStatusCode())) {
       cmp = -1;
    }

    if (shouldBeComparenByGroupCode(b1) != shouldBeComparedByGroupCode(b2)) {
        if (!shouldBeComparenByGroupCode(b1)) {
            return -1;
        } else {
           return 1;
        }
    }

    if (shouldBeComparenByGroupCode(b1) && shouldBeComparenByGroupCode(b2)) {
        String parent1 = b1.getGroupCode() == null ? "" : b1.getGroupCode().toUpperCase();
        String parent2 = b2.getGroupCode() == null ? "" : b2.getGroupCode().toUpperCase();
        cmp = parent1.compareTo(parent2);
    }

    if (cmp == 0) {
        Integer i1 = b1.getSortOrder() == null ? Const.ZERO : b1.getSortOrder();
        Integer i2 = b2.getSortOrder() == null ? Const.ZERO : b2.getSortOrder();
        cmp = i1.compareTo(i2);
    }

    if (cmp == 0) {
        String s1 = b1.getShortDescription();
        if (s1 == null) s1 = "";
        String s2 = b2.getShortDescription();
        if (s2 == null) s2 = "";
        cmp = s1.compareToIgnoreCase(s2);
    }

    return cmp;
}