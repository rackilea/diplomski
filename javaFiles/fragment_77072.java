public void forEach(IntIntProcedure p) {
  final boolean[] used = this.used;
  for (int i = 0; i < used.length; i++) {
    ...
  }
}