{
  "foo": {
    "aliases": {},
    "mappings": {
      "bar": {
        "properties": {
          "key": {
            "type": "text",
            "fields": {
              "keyword": {
                "type": "keyword",
                "ignore_above": 256
              }
            }
          }
        }
      }
    },
    "settings": {
      "index": {
        "creation_date": "1517863731064",
        "number_of_shards": "5",
        "number_of_replicas": "1",
        "uuid": "iQzvEfU0Sli3c2LRC6gjyA",
        "version": {
          "created": "5030199"
        },
        "provided_name": "foo"
      }
    }
  }
}