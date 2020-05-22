public ArrayList<Double> calculateSum(ArrayList<Iter> list) {
    ArrayList<Double> sums = new ArrayList<>();

    for (int i = 0; i < list.size() - 1; i++) {
        double sum = list.get(i).getValue() + list.get(i + 1).getValue();
        sums.add(sum);
    }
    return sums;
}