class Address {
  private String phone;

  public void setPhone(String phone) {
    if( !isValid( phone) ) { //the checks are performed in the isValid(...) method
     throw new IllegalArgumentException("please set a valid phone number");
    }

    this.phone = phone;
  }
}

//access:
Address a = new Address();
a.setPhone("001-555-12345"); //access is the same