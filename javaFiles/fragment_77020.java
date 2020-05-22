class Generator implements IntFunction<Integer[]> {
    @Override
    public Integer[] apply(int value) {
        System.out.println(new Exception().getStackTrace()[2]);
        return new Integer[value];
    }
}