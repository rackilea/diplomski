public class MultiPostcodeRange {
    private String pcode;

    public MultiPostcodeRange() {
        pcode = "XXX XXX";
    }

    public double multiPostcodeRange() {
        if (pcode.equals("GH6 TXX") || pcode.equals("NC4 LXX")) {
            return 100.0; 
        }
        else {
            return 50.0;
        }
    }
}