Diff diff = DiffBuilder.compare(refSource)
                       .withTest(testSource)
                       .checkForSimilar()
                       .ignoreWhitespace()
                       .normalizeWhitespace()
                       .withNodeMatcher(
                             new DefaultNodeMatcher(
                                    selector,ElementSelectors.Default)
                       )
                       .build();