class Validator {
    // if you stick with context, this should be a context then...
    Map<Fields, Object> matchingMode = new HashMap<>();
    static {
        matchingMode.put(Fields.FIELD_A, 123);
    }

    boolean isValid(Entry entry, Map<Fields, Object> context) {
        boolean valid = true;
        valid &= contextualEquals(entry.fieldA, Fields.FIELD_A, context, matchingMode);
        valid &= contextualEquals(entry.fieldB, Fields.FIELD_B, context, matchingMode);
        return valid;
    }


    <T> boolean contextualEquals(T entryValue, Fields field, Map<> context, Map<> matchingMode) {
        if (matchingMode.containsKey(field)) {
            return Objects.equals(entryValue, matchingMode.get(field));
        }
        return Objects.equals(entryValue, context.get(field));
    }
}