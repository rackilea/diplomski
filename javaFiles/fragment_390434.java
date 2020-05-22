@RequestMapping(method = { RequestMethod.POST})
public String update(@ModelAttribute Account account) {
     // do POST specific things..

      // and common operations
      commonOperation();
}

@RequestMapping(method = { RequestMethod.PUT })
public String updateWithPut(@ModelAttribute Account account) {
      // do PUT specific things...

      // and common operations
      commonOperation();
}

// code that put and post methods have in common
private void commonOperation() {
 // a lot of common code
 // that needs to be done
}