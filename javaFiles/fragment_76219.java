double result = 0.0;
List<Double> resultList = new ArrayList<Double>();
for (int j = 0; j < objectList.get(0).size(); j++) { // assuming all lists are of same size
    for (int i = 0; i < objectList.size(); i++) {
        result += objectList.get(i).get(j);
    }
    resultList.add(result);
    result = 0.0;
}