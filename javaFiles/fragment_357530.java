{
  "size": 0,
  "aggs": {
    "operations": {
      "terms": {
        "field": "operationCode"
      },
      "aggs": {
        "login_count": {
          "sum": {
            "field": "adet"
          }
        }
      }
    }
  },
  "query": {
    "filtered": {
      "filter": {
        "term": {
          "operationCode": "logincomplete"
        }
      }
    }
  }
}