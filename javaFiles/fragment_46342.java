GET index_5589b14f3004fb6be70e4724/document_set/_search
{
  "query": {
    "multi_match": {
      "query": "advis",
      "fields": ["plain_text", "pdf_text"],
      "analyzer" : "keyword"
    }
  },
  "explain": true
}