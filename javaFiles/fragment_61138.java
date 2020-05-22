Ignite ignite = Ignition.ignite();

        ModelDescriptorStorage descStorage = new ModelDescriptorStorageFactory().getModelDescriptorStorage(ignite);
        ModelDescriptor desc = descStorage.get(mdl);

        Model<byte[], byte[]> infMdl = new SingleModelBuilder().build(desc.getReader(), desc.getParser());

        Vector input = VectorUtils.of(x);

        try {
            return deserialize(infMdl.predict(serialize(input)));
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }