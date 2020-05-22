public static void main(String[] args) throws Exception{
    List<SeedObject> result = Stream.iterate(new SeedObject(1,1), last -> {
        int next = last.state+1;
        return new SeedObject(next, next*next);
    })
    .limit(10)
    .collect(Collectors.toList());

    System.out.println(result);
}