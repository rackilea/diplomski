/* FilterList.Operator.MUST_PASS_ALL by default */
      FilterList allFilters = new FilterList(FilterList.Operator.MUST_PASS_ONE);
      allFilters.addFilter(new PrefixFilter(Bytes.toBytes("123")));
     allFilters.addFilter(new PrefixFilter(Bytes.toBytes("456")));
     allFilters.addFilter(new PrefixFilter(Bytes.toBytes("678")));
    scan.setFilter(allFilters);

    var resultScanner = table.getScanner(scan)