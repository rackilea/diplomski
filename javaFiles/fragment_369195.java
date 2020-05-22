private void Calculate() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(file));
    jTextArea.read(br, "jTextArea");
    br = new BufferedReader(new FileReader(file));
    System.out.println(br.readLine());
}