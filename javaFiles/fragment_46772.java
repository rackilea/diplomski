GET products/_search
{
  "query": {
    "match_phrase": {
      "code": "VK"
    }
  }
}