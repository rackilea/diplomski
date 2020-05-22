class WikiParDo ... {
  private final List<String> fields;
  WikiParDo(List<String> fields) { this.fields = fields; }
    // in processElement method, use "fields" instead of calling 
    // "getTableSchema"
}

... main program: ...
TableSchema schema = getTableSchema();
List<String> fields = new ArrayList<>();
... populate fields from schema ...

p.apply(...)
 .apply(..., new WikiParDo(fields))