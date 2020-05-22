public boolean isParamAllowed(Parameter parameter, Operation operation, ApiDescription api,
        Map<String, List<String>> params, Map<String, String> cookies, Map<String, List<String>> headers) {
    if ((parameter.paramAccess().isDefined() && parameter.paramAccess().get().equals("internal")))
        return false;
    else
        return true;
}