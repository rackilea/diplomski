$ curl -XGET 'localhost:9200/test/_analyze?analyzer=lowercaseAnalyzer&pretty=true' -d 'Hello world'
{
  "tokens" : [ {
    "token" : "hello world",
    "start_offset" : 0,
    "end_offset" : 11,
    "type" : "word",
    "position" : 1
  } ]
}