GET my_index12/_search
{
"query": {
"query_string": {
  "default_field": "code",
  "query": "AB\\-7000*"
    }
  }
}