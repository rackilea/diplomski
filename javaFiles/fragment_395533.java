for (BoundField boundField : boundFields.values()) {
  if (boundField.writeField(value)) {
    out.name(boundField.name);
    boundField.write(out, value);
  }
}