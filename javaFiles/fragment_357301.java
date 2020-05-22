try {
    FileWriter fileWriter = new FileWriter("filename.ext", true);
    PrintWriter out = new PrintWriter(fileWriter);

    out.print("Text to go in the file");
    out.println("Text to go in the file");
} catch (java.io.IOException e) {
    //handle
}

out.close();   //Don't forget to close the file when done