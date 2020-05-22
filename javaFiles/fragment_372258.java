for (int j = 0; j < headerLabels[i].length; j++){
    writer.print(headerLabels[j]);
    if(j<headerLabels[i].length-1) writer.print(",");
}
writer.println();

for (int j = 0; j < headerValues[i].length; j++){
    writer.print(headerValues[i][j]);
    if(j<headerValues[i].length-1) writer.print(",");
}
writer.println();