import java.util.HashMap;
import java.util.Map.Entry;


public enum ErrorStatus {

    PAGE_NOT_FOUND("404", "Description for error 404");

    private static final HashMap<String, ErrorStatus> ERRORS_BY_CODE;
    private static final HashMap<String, ErrorStatus> ERRORS_BY_DESCR;
    static {
        ERRORS_BY_CODE = new HashMap<String, ErrorStatus>();
        ERRORS_BY_CODE.put("404", PAGE_NOT_FOUND);
        ERRORS_BY_DESCR = new HashMap<String, ErrorStatus>();
        ERRORS_BY_DESCR.put("Description for error 404", PAGE_NOT_FOUND);
    }