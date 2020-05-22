{
  "size": 0,
  "query": {
    "bool": {
      "filter": [
        {
          "range": {
            "releaseDate": {
              "from": "2018-01-01T00:00:01.531Z",
              "to": "2019-01-01T00:00:01.531Z",
              "include_lower": true,
              "include_upper": true,
              "boost": 1
            }
          }
        },
        {
          "terms": {
            "gender": [
              "action"
            ],
            "boost": 1
          }
        }
      ],
      "should": [
        {
          "bool": {
            "must_not": [
              {
                "exists": {
                  "field": "mainActorId"
                }
              }
            ]
          }
        },
        {
          "terms": {
            "mainActorId": [
              42,
              56
            ]
          }
        }
      ],
      "minimum_should_match": 1,
      "adjust_pure_negative": true,
      "boost": 1
    }
  }
}