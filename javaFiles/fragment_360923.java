public void insertPath(Tree<FileNode> t, QueueList<String> filePathQueue) {
    ...
    if(subdir == null){
        t.addChild(dir);
        insertPath(t.getFirstChild(), filePathQueue); // ONCE
    }
    insertPath(subdir, filePathQueue); // TWICE
}