public static void readUsersJava (){
setUsersMapConverter()
GdxFIRDatabase.instance().inReference("users")
        .orderBy(OrderByMode.ORDER_BY_KEY, null)
        .filter(FilterType.LIMIT_FIRST, 5)
        .readValue(List.class, new DataCallback<List<UserPOJO>>(){
        ...
        });
}