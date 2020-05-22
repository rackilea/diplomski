@Override
public Object answer(InvocationOnMock invocation) throws Throwable {
    Object[] args = invocation.getArguments();
    String methodName = invocation.getMethod().getName();
    if ("setAttribute".equals(methodName)) {
        String key = (String) args[0];
        Object value = args[1];
        attributes.put(key, value);
    } else if ("getAttribute".equals(methodName)) {
        String key = (String) args[0];
        return attributes.get(key);
    } else if ("getParameter".equals(methodName)) {
        String key = (String) args[0];
        return parameters.get(key);
    }
    return null;
}