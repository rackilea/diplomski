public static void main(String[] args) {

        String patt = "0?0?00";
        List<String> a = new ArrayList<>();
        a.add(patt);
        while (true) {
            List<String> b = generateAndGet(a);
            if (b.size() == 0) {
                break;
            }
            a = b;
        }
        for (String item : a) {
            System.out.println(item);
        }
        return;
    }



    private static List<String> generateAndGet(List<String> val) {
        List<String> result = new ArrayList<String>();
        for (String item : val) {
            final char[] itemArray = item.toCharArray();
            for (int i = 0; i < itemArray.length; i++) {
                if (itemArray[i] == '?') {
                    for (int j = 0; j < 10; j++) { 
                        itemArray[i] = (char) (j + '0');
                        result.add(String.copyValueOf(itemArray)); 
                    }
                }
            }
        }
        return result;
    }