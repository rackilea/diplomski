function iteratePath(File root, List<File> registerMe) {
      if (root!= null && root.isDirectory())  {
          registerMe.add(root);
          for (File f : root.listFiles()) {
              iteratePath(f, registerMe);
          }
      }
}