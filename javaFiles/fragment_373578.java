public void htmlToTxt(String startSite) throws Exception {
    URL u = new URL(startSite);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    BufferedWriter bw = new BufferedWriter(new FileWriter("htmlž.txt"));
    String code = new String();
    while ((code = br.readLine()) != null) {
        bw.write(code);
        bw.newLine();
    }
    bw.close();
    br.close();
    isr.close();
    is.close();
}

public static void main(String[] args) throws Exception {
    TestOMV a = new TestOMV();
    a.htmlToTxt(
            "https://webgispu.wigeogis.com/kunden/omvpetrom/client/map.php?BRAND=OMV&LNG=SI&CTRISO=SVN&MODE=NEXTDOOR&VEHICLE=CAR");

}