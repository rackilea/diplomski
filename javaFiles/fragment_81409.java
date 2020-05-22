{
  "query": {
    "filtered": {
      "filter": {
        "bool": {
          "must": [
            {
              "term": {
                "categories": "tv"
              }
            },
            {
              "nested": {
                 "path": "sellerInfoES",
                 "filter": {
                    "geo_distance": {
                       "distance": "10km",
                       "sellerInfoES.sellerLocation": {
                           "lat": "28.628978",
                           "lon":"77.21971479999999"
                       }
                    }
                 }
              }
            }
          ],
          "should": [
            {
              "term": {
                "subCategory": "led"
              }
            }
          ],
          "minimum_should_match": 1,
          "boost": 2
        }
      }
    }
  }
}