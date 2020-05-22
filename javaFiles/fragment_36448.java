public static void main(String[] args)
{
    String input = "{ \"Updated_Fields\": [ \"a\", \"b\", \"c\", \"d\" ], \"Invalid_Fields\": [ \"cd\", \"ab\" ] }";
    Gson gson = new Gson();
    FieldData data = gson.fromJson(input, FieldData.class);
    System.out.println(isInvalidFields(data.Invalid_Fields));
}

private static boolean isInvalidFields(List<String> Invalid_Fields) {
    if(CollectionUtils.isEmpty(Invalid_Fields) || Invalid_Fields.size() != 2) {
     return false;   
    }
    return Invalid_Fields.containsAll(INVALID_DATA);
}