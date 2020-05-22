interface Folder<IN, OUT> {
  OUT foldOne(OUT x, IN element);
}

<OUT>
synchronized OUT foldLeft(Folder<? super Object, OUT> folder, OUT x) {
  for (Object element : v) {
    x = folder.foldOne(x, element);
  }
  return x;
}