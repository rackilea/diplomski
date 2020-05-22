double[][] pTable = new double[30000][];
for (int i = 0; i < pTable.length; i++) {
    pTable[i] = new double[30000];
}
//
// Put lots of stuff into pTable
//
FileOutputStream fos = new FileOutputStream("pTable.ser");
ObjectOutputStream oos = new ObjectOutputStream(fos);
oos.writeObject(pTable);