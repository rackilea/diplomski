BufferedReader d = new BufferedReader(new InputStreamReader(is));
String data = "";
do {
    while((data = d.readLine()) != null)
    {
        System.out.println (data);
        jTextArea1.setText(jTextArea1.getText()+"\n"+data);
    }
} while (d.nextPage());