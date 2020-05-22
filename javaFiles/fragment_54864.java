public List<List<String>> findPaths(String label) {
    List<List<String>> result = new ArrayList<List<String>>();

    if (label.equals(this.label)) {
        result.add(new ArrayList<String>());
    }

    for (Node child : children) {
        for (List<String> subResult : child.findPaths(label)) {
            // add this.label in front
            List<String> path = new ArrayList<String>();
            path.add(this.label);
            path.addAll(subResult);
            result.add(path);
        }
    }

    return result;
}