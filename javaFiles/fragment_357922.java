private Object getValue(int fieldIndex, int index) {
    List<Object> list;
    try {
      list = data[fieldIndex];
    } catch (IndexOutOfBoundsException e) {
      throw new RuntimeException("not found " + fieldIndex + "(" + schema.getFieldName(fieldIndex) + ") in group:\n" + this);
    }
    try {
      return list.get(index);
    } catch (IndexOutOfBoundsException e) {
      throw new RuntimeException("not found " + fieldIndex + "(" + schema.getFieldName(fieldIndex) + ") element number " + index + " in group:\n" + this);
    }
  }