POST /test_index/doc/_search
{
   "query": {
      "query_string": {
         "query": "Masovian Voivodeship OR Federal District",
         "fields": [
            "dimensions.region"
         ]
      }
   }
}
...
{
   "took": 2,
   "timed_out": false,
   "_shards": {
      "total": 1,
      "successful": 1,
      "failed": 0
   },
   "hits": {
      "total": 3,
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
         },
         {
            "_index": "test_index",
            "_type": "doc",
            "_id": "1",
            "_score": 0.05937162,
            "_source": {
               "date": "2013-12-30T00:00:00.000Z",
               "value": 2,
               "dimensions": {
                  "region": "Coimbra District"
               }
            }
         }
      ]
   }
}