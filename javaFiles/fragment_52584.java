List<Integer> elements = new ArrayList<>(Arrays.asList(1,2,5,4,7,6,4,7,6,4,7));
Set<Integer> accumulator = new LinkedHashSet<>(); 
for (Integer number : elements) {
   if(Collections.frequency(elements, number) > 1)
       accumulator.add(number);   
}