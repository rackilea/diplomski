public class Test {
    static class NameFreq {
        public NameFreq(String name, int freq) {
            this.name = name;
            this.freq = freq;
        }
        String name;
        int freq;
        @Override
        public String toString() {
            return name + " " + freq;
        }
    }
    public static void main(String[] args) throws Exception {
        String str = "A. Walker, L. Gordon, C. Riley, L. Gordon";
        Map<String, NameFreq> map = new HashMap<>();
        String[] array = str.split("\\s*,\\s*");
        for(String name : array) {
            NameFreq nameFreq = map.get(name);
            if( nameFreq==null )
                map.put(name, new NameFreq(name, 1));
            else
                nameFreq.freq++;
        }

        List<NameFreq> list = new ArrayList<>(map.values());
        Collections.sort(list, new Comparator<NameFreq>() {
            @Override
            public int compare(NameFreq o1, NameFreq o2) {
                return Integer.compare(o2.freq, o1.freq);
            }
        });

        System.out.println(list);
        //output: [L. Gordon 2, A. Walker 1, C. Riley 1]
    }
}