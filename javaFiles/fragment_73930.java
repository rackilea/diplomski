class Demo {
     public static void main(String[] args) {
          ArrayList<Integer> intList = new ArrayList<>();
          ArrayList<String> stringList = new ArrayList<>();

          intList.add(1);
          intList.add("s"); //error

          stringList.add("s");
          stringList.add(2); //error
     }
}