Pattern comma = Pattern.compile(",");
Pattern empNum = Pattern.compile("(244|543)\\d+");
Pattern empType = Pattern.compile("(Contract|Permanent)");
try (Stream<String> stream = Files.lines(Paths.get("C:\\data\\sample.txt"))) {
    List<String> result = stream.skip(2).map(l -> comma.split(l))
            .filter(s -> empNum.matcher(s[2]).matches())
            .filter(s -> empType.matcher(s[5]).matches())
            .map(s -> Arrays.stream(s).collect(Collectors.joining(",")))
            .collect(Collectors.toList());
    System.out.println(result);
} catch (IOException e) {
    e.printStackTrace();
}