String filePath = context.getFilesDir().getAbsolutePath();  //returns current directory.
File file = new File(filePath, fileName);
try {
    BufferedReader br = new BufferedReader(new FileReader(file));   
    while ((line = br.readLine()) != null) {
        text.append(line);
        text.append('\n');
    }
}
catch (IOException e) {

}
return text.toString(); //the output text from file.