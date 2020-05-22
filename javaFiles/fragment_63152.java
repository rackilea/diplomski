public static <T extends String, U extends Long> U myMethod(Function<T, U> myParam, T value) {
        return otherMethod(myParam, value);
    }

    public static <T, U> U otherMethod(Function<T, U> otherParam,T value) {
        return otherParam.apply(value);
    }

    public static void main(String[] args) {
        System.out.println(myMethod(Long::valueOf, "900"));
    }