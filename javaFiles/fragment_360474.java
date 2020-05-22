public class MyMain1 {
    private static final String CONSTANT = "NaN";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/Desktop/xyz.txt"));

        List<List<Double>> allX = new ArrayList<>();
        List<List<Double>> allY = new ArrayList<>();
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();
        try {
            for (String str = null; (str = br.readLine()) != null; ) {
                String[] s = str.split(" ");
                if (CONSTANT.equals(s[0])) {
                    allX.add(x);
                    allY.add(y);
                    x = new ArrayList<>();
                    y = new ArrayList<>();
                } else {
                    x.add(Double.parseDouble(s[0]));
                    y.add(Double.parseDouble(s[1]));
                }
            }
            if (x.size() > 0 && y.size() > 0) {
                allX.add(x);
                allY.add(y);
            }
        } finally {
            br.close();
        }
    }
}