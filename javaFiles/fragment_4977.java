curl -XPOST http://localhost:9200/index/docs/3/_explain?pretty -d '{
  "query" : {
    "match" : {
      "body" : "hey earth"
    }
  }
}'