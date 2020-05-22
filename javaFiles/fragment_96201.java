String str = "hello";
int k = 2;

Optional<Character> kth = 
    Stream.of(str.split(""))
        .map(c -> c.charAt(0))
        .sorted()
        .distinct()
        .skip(k - 1)
        .findFirst();

System.out.println(kth.isPresent() ? kth.get() : "k too big!"); // h