FilterList mainFilter = new FilterList(FilterList.Operator.MUST_PASS_ALL);
    FilterList subFilter = new FilterList(FilterList.Operator.MUST_PASS_ONE);

    subFilter.addFilter(new FuzzyRowFilter(null));
    subFilter.addFilter(new FuzzyRowFilter(null));

    mainFilter.addFilter(new ColumnPrefixFilter(Bytes.toBytes("d")));
    mainFilter.addFilter(subFilter);