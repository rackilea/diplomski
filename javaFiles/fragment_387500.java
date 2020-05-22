RuntimeTypeAdapterFactory<Message> factory = RuntimeTypeAdapterFactory
    .of(Message.class, "type") // actually type is the default field to determine
                               // the sub class so not needed to set here
                               // but set just to point that it is used
    // assuming value 1 in field "int type" identifies TextMessage
    .registerSubtype(TextMessage.class, "1")
    // and assuming int 2 identifies ImageMessage
    .registerSubtype(ImageMessage.class, "2");