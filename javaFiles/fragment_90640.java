POST conn2/_update_by_query
{
  "script": {
    "inline": "ctx._source.suitename = 'TestSuite2'",
    "lang": "painless"
  },
  "query": {
    "term": {
      "suitename": "TestSuite"
    }
  }
}