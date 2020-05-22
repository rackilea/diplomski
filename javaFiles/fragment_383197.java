public void setSpecialTask(String... constructorArgs) {
  String[] args = new String[constructorArgs.length + 1);
  args[0] = "SpecialTask";
  System.arraycopy(constructorArgs, 0, args, 1, constructorArgs.length);

  setTask(args);
}