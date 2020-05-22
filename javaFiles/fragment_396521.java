PUT attach_local
{
  "mappings" : {
    "doc" : {
      "properties" : {
        "attachment" : {
          "properties" : {
            "content" : {
              "type" : "binary"
            },
            "content_length" : {
              "type" : "long"
            },
            "content_type" : {
              "type" : "text"
            },
            "language" : {
              "type" : "text"
            }
          }
        },
        "resume" : {
          "type" : "text"
        }
      }
    }
  }
}


PUT _ingest/pipeline/attach_local
{
  "description" : "Extract attachment information",
  "processors" : [
    {
      "attachment" : {
        "field" : "resume"
      }
    }
  ]
}