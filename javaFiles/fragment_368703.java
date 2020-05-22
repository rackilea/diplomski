ArrayList<CmisObject> docList = new ArrayList<CmisObject>();
Document doc1 = (Document) getSession().getObjectByPath("/bulk/bulktest1.txt");
docList.add(doc1);
Document doc2 = (Document) getSession().getObjectByPath("/bulk/bulktest2.txt");
docList.add(doc2);
Document doc3 = (Document) getSession().getObjectByPath("/bulk/bulktest3.txt");
docList.add(doc3);

HashMap<String, Object> props = new HashMap<String, Object>();
props.put("cmis:description", "description set in bulk");
List<BulkUpdateObjectIdAndChangeToken> updatedIds = getSession().bulkUpdateProperties(docList, props, null, null);

System.out.println("Updated " + updatedIds.size() + " docs.");