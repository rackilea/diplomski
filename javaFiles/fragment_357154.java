public class Ideone
{
    public static void main(String[] args)
    {
//        List<Integer> numbers = Arrays.asList(4, 5, 4, 3);
//        List<Integer> numbers = Arrays.asList(1, 9, 1, 7, 7, 5, 4, 1, 6);
        List<Integer> numbers = Arrays.asList(-1, 7, 8, -5, 4, 9, -2, 3);

        String sss = "";
        String ddd = "";
        Ideone mm = new Ideone();

        List<List<Integer>> maxi = mm.findMaxSumNonAdjacentStream(numbers, numbers.size());
        System.out.println(Collections.singletonList(maxi));

    }

    public List<List<Integer>> findMaxSumNonAdjacentStream(List<Integer> numbers, int size)
    {
        int fromIndex = 0;

        Map<Integer, Integer> maxSumMap = IntStream
                .range(fromIndex, size)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> numbers.get(i) > 0 ? numbers.get(i) : 0));

        Map<Integer, List<Integer>> indexMap = IntStream
                .range(fromIndex, size)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, Collections.singletonList(numbers.get(i))))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        maxSumMap.replace(1, Math.max(numbers.get(1), numbers.get(0)));

        List<Integer> maxValList = maxSumMap
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey() > 1)
                .map(entry -> {
                    int index = entry.getKey();
                    int prevOne = index - 1;
                    int prevTwo = index - 2;
                    int prevValOne = maxSumMap.getOrDefault(prevOne, 0);
                    int prevValTwo = maxSumMap.getOrDefault(prevTwo, 0);

                    int maxVal = Math.max(prevValOne, prevValTwo + entry.getValue());
                    boolean exclude = prevValOne > (prevValTwo + entry.getValue());

                    List<Integer> elements = new ArrayList<>();
                    if (prevValOne > 0 && exclude) {
                        elements = new ArrayList<>(indexMap.get(prevOne));
                    } else if (prevValTwo > 0 && !exclude) {
                        elements = new ArrayList<>(indexMap.get(prevTwo));
                    }

                    if (!exclude) {
                        elements.add(entry.getValue());
                        elements = elements.stream().sorted(Integer::compareTo).collect(Collectors.toList());
                    }

                    maxSumMap.replace(index, maxVal);
                    indexMap.replace(index, elements);

                    return index;
                })
                .collect(Collectors.toList());

        Integer max = maxValList
                .stream()
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);

        int lastMax = maxValList.stream().max(Integer::compareTo).orElse(-1);
        Integer maxVal = maxSumMap.get(max);

        List<Integer> result = maxSumMap
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxVal))
                .map(i -> i.getKey())
                .collect(Collectors.toList());

        Predicate<Map.Entry<Integer, List<Integer>>> containMaxList =
                mapEntry -> result.contains(mapEntry.getKey());

        return indexMap.entrySet()
                .stream()
                .filter(containMaxList)
                .map(i -> i.getValue())
                .collect(Collectors.toList());
    }
}