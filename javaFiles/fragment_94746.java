public static void main(String[] args){
    try {
        File file = new File("input.txt")
        List<String> allLines = Files.readAllLines(file.toPath(), Charset.defaultCharset());
        Collections.sort(allLines);

        //For deleting
        file.delete();
        file.createNewFile();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}