int c = -1;
LinkedList<Byte> bytestream = new LinkedList<Byte>();
while((c = inStream.read()) != -1){
    Byte b = new Byte();
    b.readInt(c);
    bytestream.add(b);
}
LinkedList<Integer> numbers = VBEncoder.decode(bytestream);
for(Integer number:numbers) System.out.println(number);
//
//here goes the code of VBEncoder.decode
public static LinkedList<Integer> decode(LinkedList<Byte> code) {
    LinkedList<Integer> numbers = new LinkedList<Integer>();
    int n = 0;
    for (int i = 0; !(code.isEmpty()); i++) {
        Byte b = code.poll(); 
        int bi = b.toInt(); 
        if (bi < 128) {
            n = 128 * n + bi;
        } else { 
            n = 128 * n + (bi - 128);
            numbers.add(n); 
            n = 0; 
        }
    }
    return numbers;
}