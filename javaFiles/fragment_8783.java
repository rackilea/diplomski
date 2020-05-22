try (PrintStream outText = new PrintStream(
        new File("C:\\Users\\myUser\\Desktop\\test.txt"), "UTF-8")) {
    if (!content.startsWith("\uFEFF")) {
        outText.print("\uFEFF");
    }
    outText.print(content);
} // Calls outText.close()