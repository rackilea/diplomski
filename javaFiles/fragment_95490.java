while ((inputLine = in.readLine()) != null) {

    // Stop translation when we reach end of document.
    if (inputLine.contains("</body>") {
        break;
    }

    if (inputLine.contains("class=\"para\" id=\"")) {
        // No changes in this block
    }

    bw.write(inputLine);
    bw.newLine();
}

// Close temporary file
tempWriter.close();

// Open temporary file, and copy verbatim to output
BufferedReader temp_in = Files.newBufferedReader(temp.toPath());
String footnotes;
while ((footnotes = temp_in.readLine()) != null) {
    bw.write(footnotes);
    bw.newLine();
}
temp_in.close();

// Finish document
bw.write(inputLine);
bw.newLine();

while ((inputLine = in.readLine()) != null) {
    bw.write(inputLine);
    bw.newLine();
}

// ... and close all open files