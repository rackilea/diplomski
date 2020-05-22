@Test
public void testBytesWritable() {

    BytesWritable bw = new BytesWritable();
    Text t1 = new Text("ABCD");
    bw.set(t1.getBytes(), 0, t1.getLength());
    System.out.println("Size: " + bw.getBytes().length);

    Text t2 = new Text("A");
    bw.set(t2.getBytes(), 0, t2.getLength());
    System.out.println("Size: " + bw.getBytes().length);

    byte[] newArray = Arrays.copyOf(bw.getBytes(), bw.getLength());
    System.out.println("Size: " + newArray.length);
}