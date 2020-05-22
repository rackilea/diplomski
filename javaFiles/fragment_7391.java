public class SomeClassTransfer extends ByteArrayTransfer {
    private final static String[] typeNames;
    private final static int[] typeIds;
    private final static SomeClassTransfer instance;

    static {
        String typeName = "SomeClassTransfer";
        int id = registerType(typeName);
        typeNames = new String[] { typeName };
        typeIds = new int[] { id };
        instance = new SomeClassTransfer();
    }

    public static SomeClassTransfer getInstance() {
        return instance;
    }

    private SomeClassTransfer() {
    }

    @Override
    protected int[] getTypeIds() {
        return typeIds;
    }

    @Override
    protected String[] getTypeNames() {
        return typeNames;
    }

    @Override
    protected void javaToNative(Object object, TransferData transferData) {
        if (object instanceof ISomeClass) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = null;
            try {
                out = new ObjectOutputStream(bos);
                out.writeObject(object);
                byte[] objectBytes = bos.toByteArray();
                object = objectBytes;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        super.javaToNative(object, transferData);
    }

    @Override
    protected ISomeClass nativeToJava(TransferData transferData) {
        ISomeClass someClass = null;

        byte[] objectBytes = (byte[]) super.nativeToJava(transferData);
        ByteArrayInputStream bis = new ByteArrayInputStream(objectBytes);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            Object o = in.readObject();
            if (o instanceof ISomeClass) {
                someClass = (ISomeClass) o;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return someClass;
    }
}