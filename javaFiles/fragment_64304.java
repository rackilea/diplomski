@Override public String toString() {
    StringBuilder result = new StringBuilder();

    result.append (this.getClass().getName() + " {");
    result.append (" Location=[" + this.Location + "]");
    result.append (", Temp=[" + this.Temp + "]");
    // Other fields.
    result.append (", Pollen=[" + this.Pollen + "]");
    result.append (" }");

    return result.toString();
  }