try(FileInputStream os=new FileInputStream(serialized);
    ObjectInputStream oos=new ObjectInputStream(os) {
        @Override
        protected ObjectStreamClass readClassDescriptor()
                                    throws IOException, ClassNotFoundException {
            final ObjectStreamClass d = super.readClassDescriptor();
            if(d.getName().equals("java.lang.invoke.SerializedLambda")) {
                return ObjectStreamClass.lookup(MySerializedLambda.class);
            }
            return d;
        }
    }) {
    Q q = (Q)oos.readObject();
}