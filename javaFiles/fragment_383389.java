Map<String, Object> sesScope = ExtLibUtil.getSessionScope();
if (null != sesScope.get("configJSON")) {
    JsonJavaObject jsonObject = (JsonJavaObject) sesScope.get("configJSON");
    System.out.println("got object?");
    System.out.println("json " + jsonObject.toString());
}