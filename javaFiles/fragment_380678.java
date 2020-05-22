List<String> fruits = new ArrayList<String>();

fruits.add("Pineapple");
fruits.add("Apple");
fruits.add("Orange");
fruits.add("Banana");

Collections.sort(fruits);

int i=0;
for(String temp: fruits){
    System.out.println("fruits " + ++i + " : " + temp);
}