{
  "properties": {
    "title": {
      "type": "string",
      "fields": {
        "en": {
          "type": "string",
          "analyzer": "english"
        }
      }
    },
    "texts": {
      "type": "nested",
      "properties": {               <--- this structure is missing
        "value": {
          "type": "string",
          "fields": {
            "en": {
              "type": "string",
              "analyzer": "english"
            }
          }
        }
      }
    }
  }
}