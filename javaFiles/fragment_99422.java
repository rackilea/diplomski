byte fileContent[] = new byte[3000];
try (FileInputStream fin = new FileInputStream(file)) {
    while(fin.read(fileContent) >= 0) {
         Base64.encodeBase64(fileContent);
    }
}