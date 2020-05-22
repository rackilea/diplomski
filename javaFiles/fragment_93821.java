interface Action {
    void apply(String targetName, String... args);
}

class ClearPathsAction implements Action {
    void apply(String targetName, String... args) {
        Destroyer destroyer = findDestroyer(targetName);
        destroyer.ClearPaths(); // args ignored
    }
}

class AddPathPredefinedAction implements Action {
    void apply(String targetName, String... args) {
        Destroyer destroyer = findDestroyer(targetName);
        int index = Integer.parseInt(args[0]);
        destroyer.AddPathPredefined(index);
    }
}

// etc.