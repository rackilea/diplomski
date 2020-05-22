StringArrayVector.Builder id = new StringArrayVector.Builder();
StringArrayVector.Builder country = new StringArrayVector.Builder(); 
DoubleArrayVector.Builder revenue = new DoubleArrayVector.Builder();
for(Record record : records) {
   id.add(record.getId());
   country.add(record.getCountry());
   revenue.add(record.getRevenue());
}

ListVector.NamedBuilder myDf = new ListVector.NamedBuilder();
myDf.setAttribute(Symbols.CLASS, StringVector.valueOf("data.frame"));
myDf.setAttribute(Symbols.ROW_NAMES, new RowNamesVector(records.size()); 
myDf.add("id", id.build());
myDf.add("country", country.build());
myDf.add("revenue", revenue.build());