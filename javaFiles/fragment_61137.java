ModelStorage storage = new ModelStorageFactory().getModelStorage(ignite);
        storage.mkdirs("/");
        storage.putFile("/my_model", serializedMdl);

        ModelDescriptor desc = new ModelDescriptor(
            "MyModel",
            "My Cool Model",
            new ModelSignature("", "", ""),
            new ModelStorageModelReader("/my_model"),
            new IgniteModelParser<>()
        );
        ModelDescriptorStorage descStorage = new ModelDescriptorStorageFactory().getModelDescriptorStorage(ignite);
        descStorage.put("my_model", desc);