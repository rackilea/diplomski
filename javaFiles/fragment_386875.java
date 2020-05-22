public static final <T> T getValueWithDefault(CheckedSupplier<T> supplier, T defaultValue) {
    try {
        return supplier.getValue();
    } catch (Exception e){
        return defaultValue;
    }
}