private static void traverse(File parentNode, String leftIndent) {
    System.out.println(leftIndent + "{");
    String indent = leftIndent + "    ";
    System.out.print(indent + "\"name\":\""
            + parentNode.getName() + "\"");
    if (!parentNode.isDirectory()) {
        System.out.println();
    } else {
        array(parentNode.listFiles(file -> file.isFile()), "files", indent);
        array(parentNode.listFiles(file -> file.isDirectory()), "folders", indent);
    }
    System.out.print(leftIndent + "}");
}

private static void array(File[] files, String attr, String leftIndent) {
    if (files == null || files.length == 0) {
        System.out.println();
    } else {
        System.out.println(",");
        System.out.print(leftIndent + "\"" + attr + "\":[");
        String indent = leftIndent + "    ";
        boolean first = true;
        for (File file: files)  {
            if (first) {
                System.out.println();
                first = false;
            } else {
                System.out.println(",");
            }
            traverse(file, indent);
        }
        System.out.print("]");
    }
}