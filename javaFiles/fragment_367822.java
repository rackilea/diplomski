public class HashTest {
        public static void main(String[] args) {
            class hmComp implements Comparator<Map.Entry<String,Integer>> {
                public int compare(Entry<String, Integer> o1,
                        Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            }
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            Random rand = new Random();
            for (int i = 0; i < 26; i++) {
                hm.put("Word" +i, rand.nextInt(100));
            }
            ArrayList list = new ArrayList( hm.entrySet() );
            Collections.sort(list, new hmComp() );
            for ( int i = 0  ; i < 15 ; i++ ) {
                System.out.println( list.get(i) );
            }

        }
    }