PUT my_index
{
  "mappings": {
    "_doc": {
      "dynamic_templates": [
        {
          "all_fields": {
            "match": "*",
            "mapping": {
              "copy_to": "my_all"
            }
          }
        }
      ],
      "properties": {
        "my_all": {
          "type": "text",
          "store": true
        }
      }
    }
  }
}