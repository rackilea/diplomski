public static void main(String[] args){
    System.out.println(retrieveFileExtension("input.txt"));
}

private static String retrieveFileExtension(String fileName) {
    try {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    } catch (Exception e) {
        return "";
    }
}