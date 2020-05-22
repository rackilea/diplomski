public void setState(String state)  {
   setFragment(state);
}

public String getState() {
   return getFragment() != null ? getFragment() : "";
}