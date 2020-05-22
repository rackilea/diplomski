GET _search
{
  "query": {
    "terms": {
      "level": [ "INFO", "TRACE" ]
    }
  }
}