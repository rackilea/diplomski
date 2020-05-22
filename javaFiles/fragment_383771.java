private static String getXSIType(String fieldType) {

    FieldType foundFieldType = FieldType.findByValue(fieldType);
    if(foundFieldType == null) {
        return CustomFieldRef.STRING.getValue();
    }
    switch(foundFieldType) {
    case FREE_FORM_TEXT:
    case EMAIL_ADRESS:
    case HELP:
    case HYPERLINK:
    case INLINE_TEXT:
    case LONG_TEXT:
    case PASSWORD:
    case PHONE_NUMBER:
    case RICH_TEXT:
    case TEXT_AREA:
        return CustomFieldRef.STRING.getValue();
    case INTEGER_NUMBER:
        return CustomFieldRef.LONG.getValue();
    case MULTIPLE_SELECT:
        return CustomFieldRef.MULTI_SELECT.getValue();
    case DOCUMENT:
    case LIST_RECORD:
    case IMAGE:
        return CustomFieldRef.SELECT.getValue();
    case CURRENCY:
    case DECIMAL_NUMBER:
    case PERCENT:
        return CustomFieldRef.DOUBLE.getValue();
    case CHECK_BOX:
        return CustomFieldRef.BOOLEAN.getValue();
    case DATE:
    case DATETIME:
    case TIME_OF_DAY:
        return CustomFieldRef.DATE.getValue();
    default:
        return CustomFieldRef.STRING.getValue();
    }
}

enum FieldType {

    FREE_FORM_TEXT("_freeFormText"),
    EMAIL_ADRESS("_eMailAddress"),
    HELP("_help"),
    HYPERLINK("_hyperlink"),
    INLINE_TEXT("_inlineText"),
    LONG_TEXT("_longText"),
    PASSWORD("_password"),
    PHONE_NUMBER("_phoneNumber"),
    RICH_TEXT("_richText"),
    TEXT_AREA("_textArea"),
    INTEGER_NUMBER("_integerNumber"),
    MULTIPLE_SELECT("_multipleSelect"),
    DOCUMENT("_document"),
    LIST_RECORD("_listRecord"),
    IMAGE("_image"),
    CURRENCY("_currency"),
    DECIMAL_NUMBER("_decimalNumber"),
    PERCENT("_percent"),
    CHECK_BOX("_checkBox"),
    DATE("_date"),
    DATETIME("_datetime"),
    TIME_OF_DAY("_timeOfDay");

    private final String value;

    FieldType(String fieldType) {
        this.value = fieldType;
    }

    public static FieldType findByValue(final String value) {
        return Arrays.stream(FieldType.values())
                .filter(o -> StringUtils.equals(o.value, value))
                .findFirst()
                .orElse(null);
    }
}

enum CustomFieldRef {

    STRING("String"),
    LONG("Long"),
    DOUBLE("Double"),
    BOOLEAN("Boolean"),
    DATE("Date"),
    SELECT("Select"),
    MULTI_SELECT("MultiSelect");

    private final String value;

    CustomFieldRef(String customFieldRef) {
        this.value = customFieldRef;
    }

    public String getValue() {
        String prefix = "platformCore";
        String suffix = "CustomFieldRef";
        return String.format("%s:%s%s", prefix, value, suffix);
    }
}