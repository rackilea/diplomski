private void changeStyleViaThemeXml() {
  try {
     Theme theme = Theme.load(getClass().getResourceAsStream(
           "/org/fife/ui/rsyntaxtextarea/themes/dark.xml"));
     theme.apply(textArea);
  } catch (IOException ioe) { // Never happens
     ioe.printStackTrace();
  }
}