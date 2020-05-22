curl -XGET "http://localhost:9200/thread_and_messages/thread/_search" -d'
{
  "query": {
    "function_score": {
      "functions": [
        {
          "field_value_factor": {
            "field": "thread_view",
            "modifier": "log1p",
            "factor": 2
          }
        }
      ],
      "query": {
        "bool": {
          "should": [
            {
              "match": {
                "thread_name": "dogs"
              }
            },
            {
              "nested": {
                "path": "messages",
                "query": {
                  "bool": {
                    "should": [
                      {
                        "match": {
                          "messages.message_text": "dogs"
                        }
                      }
                    ]
                  }
                },
                "inner_hits": {}
              }
            }
          ]
        }
      }
    }
  }
}'