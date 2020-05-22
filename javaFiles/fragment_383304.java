public String delDel(String str) {
  String del = "del";

  if (str.indexOf(del, 1) == 1){
    return str.replaceFirst("del", "");
  }

  return str;
}