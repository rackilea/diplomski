public class ParseEquation {
    public static double coeff(String str, String regex) {
        Pattern patt = Pattern.compile(regex);
        Matcher match = patt.matcher(str);
        // missing coefficient default
        String coeff = "+0";
        double value = 0;
        while(match.find()){
            coeff = match.group(1);
            value = value + Double.parseDouble(coeff);
        }
        // always have sign, handle implicit 1
        return (coeff.length() == 1) ? (value + 1) : value;
    }
    public static String[] quadParse(String arg) {
        String str = ("+" + arg).replaceAll("\\s", "");

        double a1 = coeff(str, "([+-][0-9]*)x\\^2");
        double b1 = coeff(str, "([+-][0-9]*)x(?!\\^)");
        double c1= coeff(str, "([+-][0-9]+)(?!x)");
        System.out.println("Values are a: " + a1 + " b: " + b1 + " c: " + c1);
        double dis = (Math.pow(b1, 2.0)) - (4 * a1 * c1);
        double d = Math.sqrt(dis);
        double X = 0, Y = 0; //root 1 & root 2, respectively

        if (dis > 0.0 || dis < 0.0) {
            X = (-b1 + d) / (2.0 * a1);
            Y = (-b1 - d) / (2.0 * a1);
            String root1 = Double.toString(X);
            String root2 = Double.toString(Y);
            return new String[]{root1, root2};
        } else if (dis == 0.0) {
            X = (-b1 + 0.0) / (2.0 * a1);//repeated root
            String root2 = Double.toString(X);
            return new String[]{root2};
        }
        return new String[-1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader (new InputStreamReader(System.in));
        String s;
        while ((s=r.readLine()) != null) {
            String[] pieces = quadParse(s);
            System.out.println(Arrays.toString(pieces));
        }
    }
}