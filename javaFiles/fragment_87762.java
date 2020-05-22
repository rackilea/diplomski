Arrays.sort(
   myFileArray,
   new Comparator<File>() {
     public int compare(File a, File b) {
       return a.getName().compareTo(b.getName());
     }
   });