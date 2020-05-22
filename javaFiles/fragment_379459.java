GET <index_name>/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "query_string": {
            "query": "*roj*",
            "fields":["field_1", "field_2"]
          }
        }
      ]
    }
  }
}