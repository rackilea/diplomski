DescriptorProto.Builder builder;
FieldDescriptorProto.Builder fieldBuilder =FieldDescriptorProto.newBuilder()
                            .setLabel(label)
                            .setType(type)
                            .setName("name")
                            .setTypeName("nestedMessageName")
                            .setNumber(1)
                            .setDefaultValue("value");
builder.addField(fieldBuilder.build());
builder.addNestedMessage(messageBuilder.setName("nestedMessageName").build());