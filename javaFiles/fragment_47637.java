PUT /query_index
{
  "mappings": {
    "queries": {
      "properties": {
        "query": {
          "type": "string",
          "store": true
        },
        "exact_match": {
          "type": "string",
          "index": "not_analyzed"
        },
        "search_type": {
          "type": "string",
          "store": true
        },
        "search_engine": {
          "type": "string",
          "store": true
        }
      }
    }
  }
}