public static void main(String[] args) {
    List<Long> target = new ArrayList<Long>();
    copy(new String[]{"1", "2", "3"}, target, 0);
    System.out.println(target);
}

private static void copy(String[] source, List<Long> target, int index) {
    if (index == source.length)
        return;
    target.add(Long.parseLong(source[index]));
    copy(source, target, index+1);
}