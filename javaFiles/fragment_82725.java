final String input = "one two three four five six seven eight";
final int MIN_IDX = 2;
final int MAX_IDX = 5;
final int[] idx = {-1};
String result = Arrays.stream(input.split(" "))
    .map(s -> MIN_IDX <= ++idx[0] && idx[0] <= MAX_IDX ? s.toUpperCase() : s)
    .collect(joining(" "));
System.out.println(result);