public class WritableTest {


    public class CustomObj implements Writable {
        private String value;

        public CustomObj(String v) {
            value = v;
        }

        @Override
        public void write(DataOutput out) throws IOException {
            out.writeUTF(value);
        }

        @Override
        public void readFields(DataInput in) throws IOException {
            value = in.readUTF();
        }
    }


    @Test
    public void roundTripSerialization() throws Exception
    {
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        DataOutput out = new DataOutputStream(byteOutput);

        CustomObj original = new CustomObj("originalValue");

        original.write(out);


        CustomObj deserialized = new CustomObj("you should really use add a zero arg constructor as well");

        DataInput in = new DataInputStream(new ByteArrayInputStream(byteOutput.toByteArray()));

        deserialized.readFields(in);


        Assert.assertEquals(original.value, deserialized.value);
    }
}