{
  "query": {
    "bool": {
      "filter": {
        "bool": {
          "should": [
            {
              "term": {
                "name": "name1"
              }
            },
            {
              "term": {
                "name": "name2"
              }
            }
          ]
        }
      }
    }
  }
}