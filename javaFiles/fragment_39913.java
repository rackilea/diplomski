TermFirstPassGroupingCollector firstPassCollector = new TermFirstPassGroupingCollector(
            "<grouping field name, e.g. id>",
            Sort.INDEXORDER,
            x);

searcher.search(query, firstPassCollector);

Collection<SearchGroup<String>> firstPassResult = firstPassCollector.getTopGroups(0, false)