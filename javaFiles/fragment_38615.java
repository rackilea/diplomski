static int process(Node node) {
    int complexity = 0;
    for (IfStmt ifStmt : node.getChildNodesByType(IfStmt.class)) {
        // We found an "if" - cool, add one.
        complexity++;
        printLine(ifStmt);
        if (ifStmt.getElseStmt().isPresent()) {
            // This "if" has an "else"
            Statement elseStmt = ifStmt.getElseStmt().get();
            if (elseStmt instanceof IfStmt) {
                // it's an "else-if". We already count that by counting the "if" above.
            } else {
                // it's an "else-something". Add it.
                complexity++;
                printLine(elseStmt);
            }
        }
    }
    return complexity;
}