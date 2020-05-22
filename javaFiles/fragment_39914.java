TermSecondPassGroupingCollector secondPassCollector = new TermSecondPassGroupingCollector(
            fieldNaming.getIdFieldName(),
            firstPassResult,
            Sort.INDEXORDER,
            Sort.INDEXORDER,
            maxDocsPerGroup,
            false,
            false,
            false);

searcher.search(new MatchAllDocsQuery(), secondPassCollector);