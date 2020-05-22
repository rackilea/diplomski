PUT /_river/mongodb/_meta
{ 
    "type": "mongodb", 
    "mongodb": { 
        "db": "rakeshdb", 
        "collection": "locations"
    }, 
    "index": {
        "name": "bwitter", 
        "type": "bweet" 
    }
}