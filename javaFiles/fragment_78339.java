Try This with match : 

POST /index/type/_search?v
{
    "query": {
        "match": {
           "state.country.name": "India"
        }
    }
}