Field[] fields = DocumentiDiIdentita.class.getFields();
 List documentTypes = new ArrayList();
 for(int i = 0; i < fields.length; i++){
     Field f = fields[i];
     documentTypes.add(f.get(null));
 }