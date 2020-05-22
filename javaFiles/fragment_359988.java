public static <T extends Enum<T> & Supplier<String>> List<String> getValueList(final Class<T> enumClass) {
            final Class<Supplier<String>> asSupplierClass = enumClass;
            return Arrays.stream(asSupplierClass.getEnumConstants())
                         .map(Supplier::get)
                         .collect(Collectors.toList());
    }