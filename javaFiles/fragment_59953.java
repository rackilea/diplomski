int[] original_ordering = Arrays.copyOf(mc.matrixStructure.matrixOrder);
int[][] auxiliar_matrix = Arrays.copyOf(mc.matrixStructure.matrix);
int i;

for (i = 0; i < auxiliar_matrix.length; i += 1) {
    auxiliar_matrix[i] = Arrays.copyOf(auxiliar_matrix[i]);
}