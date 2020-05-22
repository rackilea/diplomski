class Records {
    List<String> listOfType1;
    List<Integer> listOfType2;
    List<Double> listOfType3;
    public Records (List<String> l1, List<Integer> l2, List<Double> l3) {
      listOfType1 = l1;
      listOfType2 = l2;
      listOfType3 = l3;
    }
    public List<String> getListOfType1() {
      return listOfType1;
    }
    public List<Integer> getListOfType2(){
      return listOfType2;
    }
    public List<Double> getListOfType3(){
      return listOfType3;
    }
}