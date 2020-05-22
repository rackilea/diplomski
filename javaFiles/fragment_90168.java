List<String> values = new ArrayList<String>();
    values.add("AB");
    values.add("A012B");
    values.add("CD");
    values.add("1");
    values.add("10");
    values.add("01");
    values.add("9");
    values.add("I");
    Collections.sort(values, new Comparator<String>() {

        @Override
        public int compare(String o1, String o2) {
            // TODO tweak the comparator here 
            try{
            Integer integer1 = Integer.valueOf(o1);
            Integer integer2 = Integer.valueOf(o2);
            return integer1.compareTo(integer2);
            }catch (java.lang.NumberFormatException e) {
                return o1.compareTo(o2);
            }
        }
    });
    System.out.println(values);
}