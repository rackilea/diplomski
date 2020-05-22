List<Apple> apples = new ArrayList<Apple>();
apples.add(new Apple(120, "red"));
apples.add(new Apple(150, "green"));
apples.add(new Apple(150, "yellow"));
List<String> colors = apples.stream()
                            .map(Apple::getColor)
                            .collect(Collectors.toList());
System.out.println(colors);