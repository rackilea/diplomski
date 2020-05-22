public void myMethod(){
     File dir = ...;
     List<File> files = Arrays.asList(dir.listFiles());
     recurse(files.iterator());
}

private void recurse(Iterator<File> iterator){
     if (iterator.hasNext()){
          File file = iterator.next();
          report.report(file.getName());
          recurse(iterator);
     }
}