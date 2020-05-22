if(ht.containsKey("a")) {
  ht.get("a").push(0); // push some Integer
}
else {
  Stack<Integer> stack = new Stack<Integer>();
  stack.push(0); // push some integer
  ht.put("a",stack);
}