public static void exploreTree(Tree t) {
    List<Tree> child = t.getChildrenAsList();
    Tree terminal;
    for (Tree c : child) {
        if (c.isPreTerminal()) {
            terminal = c.getChild(0);
            String t_value = terminal.value();
            String c_value = c.value();
            if (!c_value.startsWith("VB")) {
                if (!t_value.equals("LOCATION") && !t_value.equals("TARGET")) {
                    terminal.setValue(c.value());
                }
            }
            // test[1].setValue(test[0].value());
        } else
            exploreTree(c);
    }
}