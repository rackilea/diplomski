List<String> mnames1 = Arrays.asList("-2l", "1r", "0p", "4p", "3l");
    System.out.println(mnames1+" before");
    Collections.sort(mnames1, new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            String m = a.substring(0,a.length()-1);
            String n = b.substring(0,b.length()-1);
            return Integer.compare(Integer.parseInt(m),Integer.parseInt(n));
        }
    });
    System.out.println(mnames1+ "after");