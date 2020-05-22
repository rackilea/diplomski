int[]    cellNums = {indexes.name, indexes.status, ... ,indexes.rpcBr};
String[] cellVals = new String[cellNums.length];
XSSFRow r = sheet.getRow(row);
for (int i=0; i<cellNums; i++)
{
    XSSFCell c = r.getCell(cellNums[i]);
    cellVals[i] = c == null ? null : c.toString();
}
RPCManager rpc = new RPCManager(
    cellVals[0],
    cellVals[1],
    ...
    cellVals[13],
    row);