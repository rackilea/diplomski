PUT _ingest/pipeline/document_attachment
    {
  "description" : "my first pipeline with handled exceptions",
  "processors" : [
    {
      "attachment" : {
        "field" : "fileContent",
        "on_failure" : [
          {
            "set" : {
              "field" : "error",
              "value" : "{{ _ingest.on_failure_message }}"
            }
          }
        ]
      }
    }
  ]
}