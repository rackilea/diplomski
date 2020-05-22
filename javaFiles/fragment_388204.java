if (source.isDirectory()) {
    for (File child : source.listFiles()) {
        if (child.isDirectory()) {
            copyDirectory(child, destination);
        } else {
            copyFile(child, destination);
        }
    }
} else {
    copyFile(source, destination);
}