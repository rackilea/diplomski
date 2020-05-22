FindOneAndReplaceOptions options = new FindOneAndReplaceOptions();
options.returnDocument(ReturnDocument.AFTER);
Document replace = Document.parse(jsonString);
replace.append("lastModifiedTs", new Date());
Document query = new Document("tracking_number", "123");
Document result = collection.findOneAndReplace(query, replace, options);