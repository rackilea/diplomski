static String fromDatabase(String str, String fontFamily) {
  if (str != null && fontFamily != null) {
    try {
      byte[] bytes = str.getBytes("ISO-8859-1"); // database encoding
      if (fontFamily.startsWith("LAB")) {
        str = new String(bytes, "Windows-1252");
      }
    }
    catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
  return str;
}

static String toDatabase(String str, String fontFamily) {
  if (str != null && fontFamily != null) {
    try {
      if (fontFamily.startsWith("LAB")) {
        str = new String(str.getBytes("Windows-1252"), "ISO-8859-1");
      }
    }
    catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
  return str;
}

public void exportFormData(EigentumsbezeichnungInformationFormData formData) throws ProcessingException {
  super.exportFormData(formData);
  formData.getWert().setValue(toDatabase(formData.getWert().getValue(), formData.getSchrift().getValue()));
}

public void importFormData(EigentumsbezeichnungInformationFormData formData) throws ProcessingException {
  super.importFormData(formData);
  getWertField().setValue(fromDatabase(formData.getWert().getValue(), formData.getSchrift().getValue()));
}