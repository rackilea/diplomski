Class<? extends Enum<?>> enumClass = null;
switch (condition) {
case 0:
    enumClass = FiveEnum.class;
    break;
case 1:
    enumClass = SevenEnum.class;
    break;
}
for (Enum<?> e : enumClass.getEnumConstants()) {
    // loop body
}