public static void main(String[] args) {
        List<String> l = new LinkedList<>();
        for(int i=0; i < 100; i++) {
            l.add("banana"+i);
        }

        for (String s : l) {
            if("banana10".equals(s)) {
                l.remove(s);
            }
        }
    }