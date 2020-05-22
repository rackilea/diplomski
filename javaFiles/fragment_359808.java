static Integer ccheck[][] = new Integer[6*6*6][4];

    Comparator<Integer[]> comp = new Comparator<Integer[]>() {
    @Override
    public Integer compare(Integer[] t, Integer[] t1) {
        Integer in1 = t[3];
        Integer in2 = t1[3];
        return in1.compareTo(in2);                
        }
    };
    Arrays.sort(ccheck, comp);