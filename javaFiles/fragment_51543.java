String input = "7,23,62,8,1130";
if (input.matches("(?:\\d+(?:,|$))+")) {
    int[] result = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
} else {
    throw new InvalidMessageException("");
}