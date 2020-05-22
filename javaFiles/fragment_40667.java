protected BooleanExpression dateCompare(DateTimePath<java.util.Date> dateTimePath, Date date, TypeCompare typeCompare) {
        StringTemplate dbDate = Expressions.stringTemplate("function('TRUNC', {0})", dateTimePath);
        StringTemplate compareDate = Expressions.stringTemplate("function('TO_DATE', {0}, {1})", DateUtils.formatRuDate(date), ORACLE_DATE_FORMAT);
        switch (typeCompare) {
            case EQ:
                return dbDate.eq(compareDate);
            case GT:
                return dbDate.gt(compareDate);
            case GOE:
                return dbDate.goe(compareDate);
            case LT:
                return dbDate.lt(compareDate);
            case LOE:
                return dbDate.loe(compareDate);
            default:
                return dbDate.eq(compareDate);
        }
    }