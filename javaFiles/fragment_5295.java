for (final FieldEnumWrapper<?> fieldEnum : ImmutableList.of(
    FieldEnumWrapper.of(EntityField.class),
    FieldEnumWrapper.of(AddressField.class),
    FieldEnumWrapper.of(PersonFunctionType.class))) {
  valueOfSearchName = fieldEnum.valueOfSearchName("POD_I_OS_PARTNER");
  // ...