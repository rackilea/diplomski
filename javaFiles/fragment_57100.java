String fullPath = mystringpath;
    String[] paths = fullPath.split("/");
    String combinedPaths = "";
    Node current = this.root;

    // We will never process the last node since it could be a repository
    // or a wildcard. The last step of this process would be doing that.
    for (int i = 0; i < paths.length - 1; i++) {
        combinedPaths += "/" + paths[i];
        if (this.collected.containsKey(combinedPaths)) {
            current = this.collected.get(combinedPaths);
        }
        else {
            String name = paths[i];
            Node childItem = new Node(name);
            current.addItem(childItem);
            current = childItem;
            this.collected.put(combinedPaths, current);
        }
    }

    // Process the last node since it represents the repository name.
        String name = paths[paths.length - 1];
        Node leafItem = new Node(name);
        combinedPaths += "/" + name;
        current.addItem(leafItem);
        current = leafItem;
        this.collected.put(combinedPaths, current);