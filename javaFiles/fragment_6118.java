TypeConverter getConverter(String attributeName) {
    Object attribute = this.getAttributeValue(attributeName);
    if (attribute == null) {
      return TypeConverters.NULL_CONVERTER;
    } else {
      AttributeType attributeType = this.extractAttributeType(attributeName, attribute);
      return attributeType == null ? TypeConverters.IDENTITY_CONVERTER : attributeType.getConverter();
    }
  }