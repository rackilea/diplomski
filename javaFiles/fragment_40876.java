ActionListener actionListener = ... // whatever object holds the method, possibly this
String[] libraries = ... // however you get your library names
JMenu parentMenu = ... // the menu you are adding them to

for (String s : libraries) {
  // prettyName is a method to make a pretty name, perhaps trimming off
  // the leading path
  JCheckBoxMenuItem child = new JCheckBoxMenuItem(prettyName(s), true);
  child.setActionCommand(s);
  parentMenu.acc(child);
}