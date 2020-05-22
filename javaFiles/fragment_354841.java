public static void main(String[] args) {
    List<String> tableOne = Lists.newArrayList("1", "2", "3", "4", "5", "6");
    List<String> tableTwo = Lists.newArrayList("2", "2", "5", "7", "8");

    diff(tableOne.iterator(), tableTwo.iterator(), String::compareTo,
            left -> System.out.println("Left " + left),
            both -> System.out.println("Both " + both),
            right -> System.out.println("Right " + right));

}