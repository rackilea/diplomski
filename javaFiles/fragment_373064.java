static <T extends TapeDrive> void doStuff(Tapelibrary<T> t) {
  List<T> listOfDrives = t.getListofDrives();

  // the user selects a drive by using a small UI or something
  T selectedDrive = listOfDrives.get(0);

  t.doSomethingWithDrive(selectedDrive);
}