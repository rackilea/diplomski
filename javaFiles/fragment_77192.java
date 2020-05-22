public static void main(String[] args) {

    System.out.println(func());

}

public static List<Double> func() {
    List<Double> dblList= new ArrayList<>();
    for (Map<Object, List<Map<String, Double>>> map : list) {
        for (List<Map<String, Double>> list : map.values()) {
            for (Map<String, Double> map1 : list) {
                for (Double dbl : map1.values()) {
                    dblList.add(dbl);

                }
            }
        }
    }
    return dblList;
}