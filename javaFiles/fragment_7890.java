class UserClass {
  String value;
  void setValue(String value) {
    this.value = value;
  }
}

class InstrumentedUserClass extends UserClass {
  @Override
  void setValue(String value) {
    MyInterceptor.intercept(value);
    super.setValue(value);
  }
}