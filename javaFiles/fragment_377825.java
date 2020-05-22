try (OutputStream output = new FileOutputStream(filepath);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output))) {

    writer.write("Number: 176");
    writer.newLine();
    writer.write("Title: Elephant");
    writer.newLine();
    writer.write("Text: This image shows a cute elephant.");
    writer.newLine();

    writer.flush();

    ImageIO.write(image, "png", output);

    output.flush();
} catch (Exception exp) {
    exp.printStackTrace();
}