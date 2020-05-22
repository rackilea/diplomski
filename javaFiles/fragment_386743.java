// Look up the extension.
ExtensionRegsitry.ExtensionInfo info =
    registry.findExtensionByNumber(
        parent.getDescriptorForType(), extensionNumber);
if (info == null) {
  throw new IllegalArgumentException("no such extension");
}

// Make a new builder for a message of the extension's type.
Message.Builder builder =
    info.defaultInstance.newBuilderForType();

// ... fill in builder however you want ...

// Insert the new sub-message into the parent.
parent.setField(info.descriptor, builder.build());