public class Test {

    public static final String START_TAG = "<ns0:Request_Bonus_Payment_Request xmlns:ns0=\"urn:com.workday/bsvc\">";

    public static final String END_TAG = "</ns0:Request_Bonus_Payment_Request>";

    public static void main(String[] args) throws Exception {
        List<String> xmls = new ArrayList<String>();

        FileReader fr = new FileReader(new File("example.txt"));
        BufferedReader br = new BufferedReader(fr);
        String temp = null;

        while ((temp=br.readLine()) !=null) {
            if (temp.contains(START_TAG)) {
                StringBuffer xml = new StringBuffer();

                while (!temp.contains(END_TAG)) {
                    xml.append(temp);
                    temp = br.readLine();
                }
                xml.append(temp);
                xmls.add(xml.toString());
            }
        }

        System.out.println("XMLs are "+xmls);

    }