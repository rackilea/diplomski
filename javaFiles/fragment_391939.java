//double the even values and put that into a list.
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
List<Integer> doubleOfEven = new ArrayList<>();

numbers.stream()
       .filter(e -> e % 2 == 0)
       .map(e -> e * 2)
       .forEach(e -> doubleOfEven.add(e)); // <--- Unnecessary use of side-effects!