jsonStr = "your json string here";

Result result = gson.fromJson(jsonStr, Result.class)

class Result{
 public String result;
 public Value value;
}

class Value{
 public int count
 public ArrayList<Data> data;
}

class Data{
 public String id;
 public String address;
 public String zipcode;
 public String name;
 public String state;
 public String city;
}