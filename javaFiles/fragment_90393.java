public static void testCombine() {
    List<String> stringList1 = new ArrayList<>(Arrays.asList("A", "AB", "XYZ", "AXTU"));
    List<Integer> integerList2 = new ArrayList<>(Arrays.asList(2, 4, 6));
    System.out.println(Main.combine(stringList1, integerList2, new MergeTwoTypes<String, Integer>() {
        @Override
        public Function<? super Integer, ? extends String> map() {
            return (x)->Integer.toString(x);
        }

        @Override
        public boolean isVal2Larger(String val, Integer val2) {
            return val.length()>val2;
        }
    }));
    List<Double> list1 = new ArrayList<>(Arrays.asList(2.3, 4.5));
    List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 5));
    System.out.println(Main.combine(list1, list2, new MergeTwoTypes<Double, Integer>() {
        @Override
        public Function<? super Integer, ? extends Double> map() {
            return ((Integer x) -> new Double(x));
        }

        @Override
        public boolean isVal2Larger(Double val, Integer val2) {
            return val>val2;
        }
    }));
}

private static <T, U> List<T> combine(List<T> vals1, List<U> vals2, MergeTwoTypes<T, U> mergeTwoTypes) {
    List<T> list=new ArrayList<>();
    int vals2Index=0;
    for(T val:vals1) {
        for(; vals2Index<vals2.size(); vals2Index++) {
            U val2=vals2.get(vals2Index);
            if(mergeTwoTypes.isVal2Larger(val, val2)) {
                list.add(mergeTwoTypes.map().apply(val2));
            }
            else {
                break;
            }
        }
        list.add(val);
    }
    for(; vals2Index<vals2.size(); vals2Index++) {
        U val2=vals2.get(vals2Index);
        list.add(mergeTwoTypes.map().apply(val2));
    }
    return list;
}

private static <T extends Comparable<? super T>> List<T> combine(List<T> vals1, List<T> vals2) {
    List<T> list=new ArrayList<>();
    list.addAll(vals1);
    list.addAll(vals2);
    Collections.sort(list);
    return list;
}

interface MergeTwoTypes<T,U> {
    boolean isVal2Larger(T val, U val2);
    Function<? super U, ? extends T> map();
}