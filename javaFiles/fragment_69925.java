int indexOfComma = -1;
int numOperands = 1;
while ((indexOfComma = read.indexOf(comma, indexOfComma+1)) != -1) {
    // snip...
    machineTables.externalSymbolTable.put(entry, tempEntryArray);
    numOperands++;
}