Diff d = DiffBuilder.compare(xmlSource1).withTest(xmlSource2)
 .checkForSimilar()
 .withNodeMatcher(nodeMatcher)
 .ignoreWhitespace()
 .ignoreComments()
 .build();