public class App 
{
    public static void main( String[] args ) throws Exception
    {
        String msg = "MSH|^~\\&|HIS|RIH|EKG|EKG|199904140038||ADT^A01||P|2.5" +
                     "PID|0001|00009874|00001122|A00977|SMITH^JOHN^M|MOM|19581119|F|NOTREAL^LINDA^M|C|564 SPRING ST^^NEEDHAM^MA^02494^US" +
                     "AL1||SEV|001^POLLEN";

        String[] segments = msg.split("(?=PID|AL1)");
        System.out.println("Initial message:");
        for (String s : segments)
            System.out.println(s);

        byte hexStartMessage = 0x0B;
        byte hexFinishMessage1 = 0x1C;
        byte hexFinishMessage2 = 0x0D;
        byte hexFinishSegment = 0x0D;

        String finalMessage = Byte.toString(hexStartMessage) + 
                intersperse(segments, hexFinishSegment) + 
                Byte.toString(hexFinishMessage1) + 
                Byte.toString(hexFinishMessage2);

        System.out.println("\nFinal message:\n" + finalMessage);           
    }

    public static String intersperse(String[] segments, byte delimiter) throws UnsupportedEncodingException {
        // uncomment this line if you wish to show the delimiter in the output
        //System.out.printf("Byte Delimiter: %s", String.format("%04x", (int)delimiter));
        StringBuilder sb = new StringBuilder();
        String defaultDelimiter = "";
        for (String segment : segments) {
            sb.append(defaultDelimiter).append(segment);
            defaultDelimiter = Byte.toString(delimiter);
        }
        return sb.toString();
    }
}