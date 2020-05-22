class UserInfo extends Observable {
  private String value_;
  public void setValue(String value)
  {
    value_ = value;
    setChanged();
  }
}