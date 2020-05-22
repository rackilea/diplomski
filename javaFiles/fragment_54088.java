// Create the Storage service object
Storage storage = new Storage(httpTransport, jsonFactory, credential);

// Create a new batch request
BatchRequest batch = storage.batch();

// Add some requests to the batch request
storage.objectAccessControls().insert("bucket-name", "object-key1",
    new ObjectAccessControl().setEntity("user-123423423").setRole("READER"))
    .queue(batch, callback);
storage.objectAccessControls().insert("bucket-name", "object-key2",
    new ObjectAccessControl().setEntity("user-guy@example.com").setRole("READER"))
    .queue(batch, callback);
storage.objectAccessControls().insert("bucket-name", "object-key3",
    new ObjectAccessControl().setEntity("group-foo@googlegroups.com").setRole("OWNER"))
    .queue(batch, callback);

// Execute the batch request. The individual callbacks will be called when requests finish.
batch.execute();