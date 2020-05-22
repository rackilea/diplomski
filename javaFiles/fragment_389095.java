curl -XPOST 'http://localhost:9200/test/entry/_search?pretty=true' -d '{ 
  "query":{
    "custom_boost_factor" :{
      "query" : {
        "text_phrase_prefix" : {
          "title" : "test"
        }
      },
      "boost_factor": 2.0
    }
  }
}'