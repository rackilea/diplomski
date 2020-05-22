public class Sample {

    public Sample(){}
    public int kk;
    public List<Map<String,String>> fields;


    public static void main(String[] args) {
        String s = "[{\"kk\":1, \"fields\":[{\"a\":\"a1\"}]}, {\"kk\":5}, {\"kk\":2}, {\"kk\":8}, {\"kk\":6, \"fields\":[{\"b\":\"b1\"}]}]";
        Sample[] r = new Gson().fromJson(s, Sample[].class);
        for(Sample t: r)
            System.out.println(">> " + t.kk + " " + t.fields);
    }

}