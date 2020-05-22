List<String> cities = Arrays.asList({city1, city2, city3});
Collections.sort(cities);

System.out.println("Cities sorted lexicographical:");
for (String city : cities) {
    System.out.println(city);
}