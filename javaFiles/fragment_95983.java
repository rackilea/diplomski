import java.util.HashMap;
import java.util.Map;

public class EnumSample {

    public static enum LoginErrorCode {

        EMAIL_OR_PASSWORD_INCORRECT("101"), EMAIL_INCORRECT("102"), UNKNOWN_ERROR_CODE("---");

        private static Map<String, LoginErrorCode> codeToEnumMap;

        private final String code;

        LoginErrorCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }


        /**
         * Looks up enum based on code.  If code was not registered as enum, it returns UNKNOWN_ERROR_CODE
         * @param code
         * @return
         */
        public static LoginErrorCode fromCode(String code) {
            // Keep a hashmap of mapping between code and corresponding enum as a cache.  We need to initialize it only once
            if (codeToEnumMap == null) {
                codeToEnumMap = new HashMap<String, EnumSample.LoginErrorCode>();
                for (LoginErrorCode aEnum : LoginErrorCode.values()) {
                    codeToEnumMap.put(aEnum.getCode(), aEnum);
                }
            }

            LoginErrorCode enumForGivenCode = codeToEnumMap.get(code);
            if (enumForGivenCode == null) {
                enumForGivenCode = UNKNOWN_ERROR_CODE;
            }

            return enumForGivenCode;
        }
    }

    public static void main(String[] args) {

        System.out.println( LoginErrorCode.fromCode("101")); //Prints EMAIL_OR_PASSWORD_INCORRECT
        System.out.println( LoginErrorCode.fromCode("102")); //Prints EMAIL_INCORRECT
        System.out.println( LoginErrorCode.fromCode("999")); //Prints UNKWNOWN_ERROR_CODE
    }
}