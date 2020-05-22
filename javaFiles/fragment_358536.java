try {
    Integer id = jsonObject.get("id").getAsInt();
    // it's a number!!
    MyIntegerPojo integerPojo = new Gson().fromJson(jsonObject, MyIntegerPojo.class);
} catch (ClassCastException e) {
    // it's not a number
    MyStringPojo stringPojo = new Gson().fromJson(jsonObject, MyStringPojo.class);
}