boolean isValid(Entry entry, Context context) {
    boolean valid = true;
    valid &= contextualEquals(entry.fieldA, this.fieldA, context.fieldA, fieldA.matchingMode);
    valid &= contextualEquals(entry.fieldB, this.fieldB, context.fieldB, fieldB.matchingMode);
    return valid;
}