int main(void) {
  float Xy[3][3] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
  float **transposed = transpose(3, 3, &Xy[0][0]);
  int i, j;
  for (i = 0; i < 3; i++)
    for (j = 0; j < 3; j++)
      printf("%f ", transposed[i][j]);
  printf("\n");
  free_mem_m(3, transposed);
  return 0;
}