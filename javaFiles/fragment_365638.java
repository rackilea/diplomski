query = new BasicDBObject(
  "formatted_date",
  new BasicDBObject("$gte", startDate).append("$lte", endingDate)
);
cursor = collection.find(query);

try {
  while (cursor.hasNext()) {
    System.out.println(cursor.next());
  }
} finally {
  cursor.close();
}