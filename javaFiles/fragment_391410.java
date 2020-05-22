@Override
    public OrderSpecifier<?> getOrderByClause(SortKey sortKey) {
        BooleanPath path = getBooleanPath();
        if (sortKey.getSortOrder() == ESortOrder.ASCENDING) {
            return path.asc();
        }
        return path.desc();
    }

    private BooleanPath getBooleanPath() {
        return Expressions.booleanPath(getFieldName());
    }