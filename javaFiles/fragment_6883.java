POST /test_index/doc/_search
{
   "query": {
      "query_string": {
         "query": "(Masovian AND Voivodeship) OR (Federal AND District)",
         "fields": [
            "dimensions.region"
         ]
      }
   }
}
...
{
   "took": 3,
   "timed_out": false,
   "_shards": {
      "total": 1,
      "successful": 1,
      "failed": 0
   },
   "hits": {
      "total": 2,
      "max_score": 0.46911472,
      "hits": [
         {
            "_index": "test_index",
            "_type": "doc",
            "_id": "3",
            "_score": 0.46911472,
            "_source": {
               "date": "2013-12-30T00:00:00.000Z",
               "value": 1,
               "dimensions": {
                  "region": "Masovian Voivodeship"
               }
            }
         },
         {
            "_index": "test_index",
            "_type": "doc",
            "_id": "2",
            "_score": 0.3533006,
            "_source": {
               "date": "2013-12-30T00:00:00.000Z",
               "value": 1,
               "dimensions": {
                  "region": "Federal District"
               }
            }
         }
      ]
   }
}