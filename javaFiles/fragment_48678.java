public static void main(String[] args) throws IOException {

    String title = "Princes";
    String name  = "Luna";
    String community = "Stackoverflow";

    InputStream stream = DemoMailCreater.class.getResourceAsStream("demo.mail");


    byte[] buffer = new byte[stream.available()];
    stream.read(buffer);

    String text = new String(buffer);

    text = text.replaceAll("§TITLE§", title);
    text = text.replaceAll("§NAME§", name);
    text = text.replaceAll("§COMMUNITY§", community);

    System.out.println(text);

}