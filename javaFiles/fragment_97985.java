public static final String MESSAGE = "hello.message";

/**
 * Field for Message property.
 */
private String message;

/**
 * Return Message property.
 *
 * @return Message property
 */
public String getMessage() {
    return message;
}
private StringUtil stringUtil = new StringUtil();

public StringUtil getStringUtil() {
  return stringUtil;
}

public String execute() throws Exception {
    setMessage(getText(MESSAGE));
    OgnlRuntime.setMethodAccessor(StringUtil.class, stringUtil);
    return SUCCESS;
}