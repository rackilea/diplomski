try {
   LibraryLoader.loadJacobLibrary();
   ActiveXComponent oWord = new ActiveXComponent("Word.Application");
   oWord.setProperty("Visible", new Variant(true));
 } catch (Throwable th) {
   th.printStackTrace(new java.io.PrintWriter(out));
 }