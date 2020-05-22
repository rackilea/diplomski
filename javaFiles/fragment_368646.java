StringBuilder builder = new StringBuilder();
for (int kk = 0; kk < W2.getRowDimension(); kk++) {
    for (int jj = 0; jj < W2.getColumnDimension(); jj++) {
        builder.append(reduceMatrix[kk][jj])
               .append(",");
    }
    builder.append("\n"); // Or whatever line terminator you want
}