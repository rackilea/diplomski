String current line = "";
StringBuilder fileOutput = new StringBuilder();
while((currentLine = reader.readLine()) != null) {
    fileOutput.append(currentLine)
}
//the rest of the code above (obviously don't set `fileOutput` twice though)