fc = new JFileChooser();

    fc.setFileFilter(new FileFilter() {

      public String getDescription() {
          return "Excel Documents (.xlsx)";
      }

      public boolean accept(File f) {
          if (f.isDirectory()) {
              return true;
          } else {
              String filename = f.getName().toLowerCase();
              return filename.endsWith(".xlsx") ;
          }
      }
   });