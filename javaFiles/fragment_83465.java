DELETE /test_index/drama/_query
{
  "query": { 
    "query": {
        "match_all": {}
    }
  }
}