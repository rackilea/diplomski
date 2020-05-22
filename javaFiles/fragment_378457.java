@Override
public void transform(SolrDocument doc, int docid) {

  FieldType idFt = idField.getType();
  Object parentIdField = doc.getFirstValue(idField.getName());

  // *** line 137 ***
  String parentIdExt = parentIdField instanceof IndexableField
    ? idFt.toExternal((IndexableField)parentIdField)
    : parentIdField.toString();