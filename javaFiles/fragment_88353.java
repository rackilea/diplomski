try(PrintWriter out = new PrintWriter(new FileOutputStream("outputfile.txt", true))) {
// note the boolean parameter in FileOS constructor above. Its "true" value means "Append"
    out.println(text);
} catch (FileNotFoundException e) {
    e.printStackTrace();
}