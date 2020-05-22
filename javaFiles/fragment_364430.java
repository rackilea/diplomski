@PostMapping(value= "/newContact")
  public String createNewContact(@RequestBody ContactDTO newContact) {
    if (newContact.getPhones() !=null) {
      // method that persists phone data
    }
   // .. use a CRUDRepository object to persist the data to MySQL DB
    return "savedContact";
  }