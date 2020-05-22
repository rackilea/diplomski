PUT products
{
"settings": {
"analysis": {
  "analyzer": {
    "custom_analyzer": {
      "type": "custom",
      "tokenizer": "ngram",
      "char_filter": [
        "html_strip"
      ],
      "filter": [
        "lowercase",
        "asciifolding"
      ]
    }
  }
}
},
"mappings": {
"doc": {
  "properties": {
    "code": {
      "type": "text",
       "analyzer": "custom_analyzer"
      }
    }
  }
 }
}