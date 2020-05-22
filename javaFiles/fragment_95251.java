@NonNull Object @Nullable [] array; // Nullable array of non-null objects
@Nullable Object @NonNull [] array; // Non-null array of nullable objects

@Foo List<@Foo Integer> doSomething(@Foo Integer @Foo [] arrayOfIntegers, @Foo long x) {
    arrayOfIntegers[0] = (@Foo int) x;
    return Arrays.asList(arrayOfIntegers);
}