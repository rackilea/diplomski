byte[] data = Base64.decodeBase64(base64string);
try {
    OutputStream stream = new FileOutputStream(output_file_name)
    stream.write(data); 
} catch (Exception e) {
    //Catch IOException errors
}