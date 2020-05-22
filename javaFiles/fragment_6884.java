POST /test_index/doc/_search
{
   "query": {
      "bool": {
         "should": [
            {
               "match": {
                  "dimensions.region": {
                     "query": "Masovian Voivodeship",
                     "operator": "and"
                  }
               }
            },
            {
               "match": {
                  "dimensions.region": {
                     "query": "Federal District",
                     "operator": "and"
                  }
               }
            }
         ]
      }
   }
}