{
  "query": {
    "bool": {
      "filter": [
        {
          "script": {
            "script": {
              "source": "(doc['ACount'].value + doc['BCount'].value) > params.count",
              "params": {
                "count": 100
              }
            }
          }
        }
      ]
    }
  }
}