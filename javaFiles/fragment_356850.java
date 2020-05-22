field.getDocument().addDocumentListener(docListener);
field1.getDocument().addDocumentListener(docListener);

///////////you should change text field after adding document listner not before//////////////////
/* move textfield settext code part like that*/
try {
    InputStream ips = new FileInputStream("test.txt");
    InputStreamReader ipsr = new InputStreamReader(ips);
    BufferedReader br = new BufferedReader(ipsr);
    String line;
    while ((line = br.readLine()) != null) {
        field.setText(line);
    }
    br.close();
} catch (Exception e) {
    e.printStackTrace();
}
//////////////////////////////////////////////////////////////////////////////////////