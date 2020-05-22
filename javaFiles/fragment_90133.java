int len = String.valueOf(System.currentTimeMillis()).length();
    String expr = "^[0-9]{" + len + "}" + String.valueOf(seperator) + vid + "$";

    // just kidding... not rely on flag at all.. use 0
    int flag = Pattern.CASE_INSENSITIVE | Pattern.DOTALL;
    RegexStringComparator.EngineType engineType = RegexStringComparator.EngineType.JAVA;

    RowFilter rowFilter = new RowFilter(CompareFilter.CompareOp.EQUAL,
            new RegexStringComparator(expr, flag, engineType));