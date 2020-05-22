boolean isJavaFxAvailable;
try {
  Class jfxPanel = classLoader.loadClass("javafx.embed.swing.JFXPanel");
  isJavaFxAvailable = true;
} catch (ClassNotFoundException e) {
  isJavaFxAvailable = false;
}