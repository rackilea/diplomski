StringBuilder sb=new StringBuilder();
for (int i = 0; i < resultMatrix.length; i++) {
    for (int j = 0; j < resultMatrix[i].length; j++) {
        sb.append(resultMatrix[i][j]);
        if (j != resultMatrix[i].length - 1) sb.append(",");
    }
    sb.append("\n");
}

String fileOutputString=sb.toString();