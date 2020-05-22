public static <T extends Enum<T> & Supplier<String>> List<String> getValueList(final Class<T> enumClass) {
            return Arrays.stream(enumClass.getEnumConstants())
                         .map(x -> (Supplier<String>) x) // not needed to compile but needed for run-time.
                         .map(Supplier::get)
                         .collect(Collectors.toList());
    }