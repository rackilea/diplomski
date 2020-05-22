curl -XPOST http://localhost:9200/index/_search?pretty -d '{
  "query" : {
    "match" : {
      "body" : "hey earth"
    }
  }
}'