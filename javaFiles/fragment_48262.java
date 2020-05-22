try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
    String[] strings = getTextArea_1.split("\n");
    for (String s : strings){
        writer.write(s);
        writer.newLine();        
    }
} catch (IOException e) {
    e.printStackTrace();
}