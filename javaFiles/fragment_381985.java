List<String> alA = new ArrayList<>();
List<List<String>> alB = new ArrayList<>();

alA.add("1");
alA.add("2");
alA.add("3");

alB.add(alA);

System.out.println(alB.get(0).get(2));