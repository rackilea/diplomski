public class CodeableEnumHelper {
    public static CodeableEnum getByCode(String code, CodeableEnum[] values) {
        for (CodeableEnum e : values) {
            if (e.getCode().equalsIgnoreCase(code)) {
                return e;
            }
        }
        return null;
    }
}