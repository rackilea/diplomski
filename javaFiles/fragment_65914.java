@Rule(key = "foo_key", name = "Foo issue", description = "Foo issue", priority = Priority.INFO)
public class FooCheck extends IssuableSubscriptionVisitor {

    private static final Map<String, Collection<Integer>> linesWithIssuesByClass = new HashMap<>();

    @Override
    public List<Kind> nodesToVisit() {
        return ImmutableList.of(Kind.NEW_CLASS);
    }

    @Override
    public void visitNode(Tree tree) {
        if (lineAlreadyHasThisIssue(tree)) {
            return;
        }

        reportIssue(tree);
    }

    private boolean lineAlreadyHasThisIssue(Tree tree) {
        if (tree.firstToken() != null) {
            final String classname = getFullyQualifiedNameOfClassOf(tree);
            final int line = tree.firstToken().line();

            return linesWithIssuesByClass.containsKey(classname)
                    && linesWithIssuesByClass.get(classname).contains(line);
        }

        return false;
    }

    private void reportIssue(Tree tree) {
        if (tree.firstToken() != null) {
            final String classname = getFullyQualifiedNameOfClassOf(tree);
            final int line = tree.firstToken().line();

            if (!linesWithIssuesByClass.containsKey(classname)) {
                linesWithIssuesByClass.put(classname, new ArrayList<>());
            }

            linesWithIssuesByClass.get(classname).add(line);
        }

        reportIssue(tree, "New class!");
    }

    private String getFullyQualifiedNameOfClassOf(Tree tree) {
        Tree parent = tree.parent();

        while (parent != null) {
            final Tree grandparent = parent.parent();

            if (parent.is(Kind.CLASS) && grandparent != null && grandparent.is(Kind.COMPILATION_UNIT)) {
                final String packageName = getPackageName((CompilationUnitTree) grandparent);

                return packageName.isEmpty()
                        ? getClassName((ClassTree) parent)
                        : packageName + '.' + getClassName((ClassTree) parent);
            }

            parent = parent.parent();
        }

        return "";
    }

    private String getPackageName(CompilationUnitTree compilationUnitTree) {
        final PackageDeclarationTree packageDeclarationTree = compilationUnitTree.packageDeclaration();
        if (packageDeclarationTree == null) {
            return "";
        }

        return packageDeclarationTree.packageName().toString();
    }

    private String getClassName(ClassTree classTree) {
        final IdentifierTree simpleName = classTree.simpleName();
        return simpleName == null
                ? ""
                : simpleName.toString();
    }

}