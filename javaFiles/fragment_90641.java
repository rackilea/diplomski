POST _reindex
{
  "source": {
    "index": "conn2"
  },
  "dest": {
    "index": "new_index"
  },
  "script": {
    "source": "if (ctx._source.suitename == 'TestSuite') {ctx._source.suitename = 'TestSuite2'}",
    "lang": "painless"
  }
}