private static final String PATTERN = "[^a-z0-9]+|(?<=[a-z])(?=[0-9])|(?<=[0-9])(?=[a-z])";
    public static void main(String[] args) {
        List<String> l = Arrays.asList("abc12","abc2","xyz3","pqr23","pqr99","wer12");
        Collections.sort(l, new Comparator<String>(){
            @Override
            public int compare(String arg0, String arg1) {
                String [] arr0 = arg0.split(PATTERN);
                String [] arr1 = arg1.split(PATTERN);
                int cmp = arr0[0].compareTo(arr1[0]);
                return cmp != 0 ? cmp : Integer.compare(Integer.parseInt(arr0[1]), Integer.parseInt(arr1[1]));
            }           
        });
        System.out.println(l);
    }