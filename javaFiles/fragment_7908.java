private native Integer getValue1() /*-{
  return this.value1 == null ? null : @java.lang.Integer::valueOf(I)(this.value1);
}-*/;

private native Long getValue2() /*-{
  return this.value2 == null ? null : @my.app.client.Dto::doubleToLong(D)(this.value2);
}-*/;

private static Long doubleToLong(double d) {
  return Long.valueOf((long) d);
}