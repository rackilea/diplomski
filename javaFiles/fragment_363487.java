public static void main(String[] args) {
    List<String> list2 = Arrays.asList("adf", "bcd", "abc", "hgr", "jyt", "edr", "biu");

    String collect = list2.stream().collect(StringBuilder::new, (res, elem) -> {
        res.append(" ").append(elem);
    }, (res1, res2) -> {
        res1.append(res2.toString());
        System.out.printf("res1=%s, res2=%s\n", res1, res2);
    }).toString();
    System.out.println("collect=" + collect);
}