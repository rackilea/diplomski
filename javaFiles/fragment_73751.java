public static void main(String args[]){

        List<ArrayList<Double>> list1 = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> list2 = new ArrayList<Double>();

        list2.add(1.0);
        list2.add(1.0);
        list1.add(list2);

        list2 = new ArrayList<Double>();
        list2.add(2.0);
        list2.add(2.0);
        list1.add(list2);

        Double[][] dim = new Double[2][2];
        int i = 0;
        for(ArrayList<Double> inner : list1)
            dim[i++] = inner.toArray(new Double[0]);
    }