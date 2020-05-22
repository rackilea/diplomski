PUT facebook
{
  "mappings": {
    "my_type": {
      "properties": {
        "content": {
          "type": "completion"
        }
      }
    }
  }
}