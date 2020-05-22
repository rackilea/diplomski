Parser parser = Parser.create();
CompilationUnitTree tree = parser.parse(file, new InputStreamReader(stream), null);

for (Tree tree : tree.getSourceElements()) {
    System.out.println(tree.getKind());

    switch(tree.getKind()) {
        case FUNCTION:
            [...]
    }
}