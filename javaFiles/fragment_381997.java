public static class Builder extends ParquetWriter.Builder<Group, Builder> {
    private MessageType type = null;
    private Map<String, String> extraMetaData = new HashMap<String, String>();

    private Builder(Path file) {
      super(file);
    }

    public Builder withType(MessageType type) {
      this.type = type;
      return this;
    }

    public Builder withExtraMetaData(Map<String, String> extraMetaData) {
      this.extraMetaData = extraMetaData;
      return this;
    }

    @Override
    protected Builder self() {
      return this;
    }

    @Override
    protected WriteSupport<Group> getWriteSupport(Configuration conf) {
      return new GroupWriteSupport(type, extraMetaData);
    }

  }