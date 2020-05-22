curl -XGET "http://localhost:9200/index_name/_search" -d'
{
  "size": 0,
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "logLevel": "ERROR"
          }
        },
        {
          "range": {
            "date": {
              "gte": "enter_date_here"
            }
          }
        }
      ]
    }
  }
}'