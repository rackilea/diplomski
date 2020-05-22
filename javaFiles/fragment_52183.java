Gson gson = new Gson();
gson.toJson(1);                   // prints 1
gson.toJson("abcd");              // prints "abcd"
gson.toJson(new Long(10));        // prints 10
int[] values = { 1 };
gson.toJson(values);              // prints [1]