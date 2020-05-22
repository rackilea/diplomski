public enum Contents {
  VarA { public String get(Database d) { return d.getVarA(); } },
  VarB { public String get(Database d) { return d.getVarB(); } },
  VarC { public String get(Database d) { return d.getVarC(); } };
  public String get(Database d) { return ""; }
}