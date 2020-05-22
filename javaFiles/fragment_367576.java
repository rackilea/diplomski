private class AnnotationVisitor extends TreePathScanner<TypeMirror, Void> {
    @Override
    public TypeMirror visitAnnotation(AnnotationTree node, Void p) {
        for (ExpressionTree expressionTree : node.getArguments()) {
            if (!(expressionTree instanceof AssignmentTree)) {
                continue;
            }

            AssignmentTree assignmentTree = (AssignmentTree)expressionTree;
            ExpressionTree variable = assignmentTree.getVariable();
            if (!(variable instanceof IdentifierTree) || !((IdentifierTree)variable).getName().contentEquals("rule")) {
                continue;
            }

            return scan(expressionTree, p);
        }

        return null;
    }

    @Override
    public TypeMirror visitAssignment(AssignmentTree at, Void p) {
        return scan(at.getExpression(), p);
    }

    @Override
    public TypeMirror visitMemberSelect(MemberSelectTree mst, Void p) {
        return scan(mst.getExpression(), p);
    }

    @Override
    public TypeMirror visitIdentifier(IdentifierTree it, Void p) {
        return trees.getTypeMirror(this.getCurrentPath());
    }
}