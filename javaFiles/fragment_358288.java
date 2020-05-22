return objectMap.entrySet().stream()
        .filter(fieldDescriptorObjectEntry -> {
            Descriptors.FieldDescriptor descriptor = fieldDescriptorObjectEntry.getKey();
            return descriptor.getName().equals(fieldName);
        })
        .findFirst()
        .map(fieldDescriptorObjectEntry -> fieldDescriptorObjectEntry.getValue());