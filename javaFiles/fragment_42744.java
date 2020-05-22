public static File createOutputFolder() {
   final File desktop = new File(System.getProperty("user.home"), "Desktop")
   final File output = new File(desktop, "output");

   if (!output.exists()) {
          // The directory does not exist already, we create it
          output.mkdirs();
    } else if (!output.isDirectory()) {
          throw new IllegalStatexception("The output path already exists but is no directory: " + output);
    }

    return output;
}