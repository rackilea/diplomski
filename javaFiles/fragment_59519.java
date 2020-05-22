List<Integer> numbers = new ArrayList<Integer>();
for (int i = 1; i <= 1000; i++) {
    numbers.add(Integer.valueOf(i));
}

int totalItems = numbers.size();
int itemPerGroup = 70;
int totalGroup = (totalItems / itemPerGroup) + 1;
List<List<Integer>> groups = new ArrayList<List<Integer>>();
for (int groupCount = 1; groupCount <= totalGroup; groupCount++) {
    int groupStartIndex = (groupCount - 1) * itemPerGroup;
    int groupEndIndex = Math.min(numbers.size(), groupCount * itemPerGroup);
    groups.add(numbers.subList(groupStartIndex, groupEndIndex));
}