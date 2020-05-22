GET /_search
{
    "query": {
        "wildcard": {
            "field_name": {
                "value": "*goog*",              
            }
        }
    }
}