public class Test {
    private String e1;

    public String getE1() {
        return e1;
    }

    public void setE1(String e1) {
        this.e1 = e1;
    }

    public static void main(String[] args) throws Exception {
        String xml = "<Test><e1>test</e1></Test>";
        Test t = JAXB.unmarshal(new StringReader(xml), Test.class);
        System.out.println(t.getE1());
    }
}