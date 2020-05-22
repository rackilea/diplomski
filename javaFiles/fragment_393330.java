public class Main {

    public static void main(String[] args) throws ParseException {

        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();

        WrapperTest wrapper1 = new WrapperTest(jPanel1, jLabel1);

        Map<String, WrapperTest> mapItems = new HashMap<String, WrapperTest>();
        mapItems.put("key1", wrapper1);

    }

}