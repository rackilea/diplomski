/**
 * This function builds a classpath from the passed Strings
 * 
 * @param paths classpath elements
 * @return returns the complete classpath with wildcards expanded
 */
private static String buildClassPath(String... paths) {
    StringBuilder sb = new StringBuilder();
    for (String path : paths) {
        if (path.endsWith("*")) {
            path = path.substring(0, path.length() - 1);
            File pathFile = new File(path);
            for (File file : pathFile.listFiles()) {
                if (file.isFile() && file.getName().endsWith(".jar")) {
                    sb.append(path);
                    sb.append(file.getName());
                    sb.append(System.getProperty("path.separator"));
                }
            }
        } else {
            sb.append(path);
            sb.append(System.getProperty("path.separator"));
        }
    }
    return sb.toString();
}