void free_mem_m(int m, float **array) {
  int i;
  for (i = 0; i < m; i++) {
    free(array[i]);
  }
  free(array);
}