DELETE /test_index

PUT /test_index
{
   "settings": {
      "number_of_shards": 1,
      "number_of_replicas": 0
   }
}

PUT /test_index/doc/1
{
    "date": "2013-12-30T00:00:00.000Z",
    "value": 2,
    "dimensions": {
        "region": "Coimbra District"

    }
}

PUT /test_index/doc/2
{
    "date": "2013-12-30T00:00:00.000Z",
    "value": 1,
    "dimensions": {
        "region": "Federal District"        
    }
}

PUT /test_index/doc/3
{
    "date": "2013-12-30T00:00:00.000Z",
    "value": 1,
    "dimensions": {
        "region": "Masovian Voivodeship"
    }
}