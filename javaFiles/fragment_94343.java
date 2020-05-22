final String entryName = "entry";
    final String keyName = "key";
    final Class<String> keyType = String.class;
    final String valueName = "value";
    final Class<String> valueType = String.class;
    NamedMapConverter statmConverter = new NamedMapConverter(
            xstream.getMapper(), entryName, keyName, keyType, valueName,
            valueType);
    xstream.registerLocalConverter(ATSP.class, "STATM", statmConverter);