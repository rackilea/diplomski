$ curl -XPUT 'localhost:9200/test/_settings' -d '
  {
    "index": {
      "analysis" : {
        "analyzer" : {
          "lowercaseAnalyzer": {
            "type": "custom",
            "tokenizer": "keyword",
            "filter": ["lowercase"]
          }
        }
      }
    }
  }