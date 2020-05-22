public class BouncyCastle {

    public static void main(String[] args) throws IOException {

        DetailOutputRecord detailOutputRecord = new DetailOutputRecord();
        MyRecord myRecord = new MyRecord();

        myRecord.setOriginNodeType(new NodeType("xxxx".getBytes()));
        myRecord.setTransactionAmount(new MoneyAmount("xxxx".getBytes()));
        myRecord.setSubscriberNumber(new NumberString("xxxx".getBytes()));

        ReverseByteArrayOutputStream ros = new ReverseByteArrayOutputStream(1000);

        detailOutputRecord.setMyRecord(myRecord);
        myRecord.encode(ros);
        System.out.println(DatatypeConverter.printHexBinary(ros.getArray()));
        System.out.println(print(ros.getArray()));

        DERTaggedObject dermyRecord = new DERTaggedObject(false, 6, ASN1Primitive.fromByteArray(ros.getArray()));


        File f = new File(String.valueOf("1_dermyRecord.ASN"));
        FileOutputStream stream = new FileOutputStream(f);
        try {
            stream.write(dermyRecord.getEncoded());
        } finally {
            stream.close();
        }

        ros = new ReverseByteArrayOutputStream(1000);
        detailOutputRecord.encode(ros);

        DLSequence ddetailOutputRecord = new DLSequence(ASN1Primitive.fromByteArray(ros.getArray()));
        stream = new FileOutputStream(new File("detailOutputRecord.ASN"));
        try {
            stream.write(ros.buffer);
        } finally {
            stream.close();
        }



    }

    public static String print(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (byte b : bytes) {
            // sb.append(String.format("0x%02X ", b));
            sb.append(String.format("\\x%02X", b));
        }
        sb.append("]");
        return sb.toString();
    }

    private static DERTaggedObject toDERObject(byte[] data) throws IOException {
        ByteArrayInputStream inStream = new ByteArrayInputStream(data);
        ASN1InputStream asnInputStream = new ASN1InputStream(inStream);

        return (DERTaggedObject) asnInputStream.readObject();
    }
}