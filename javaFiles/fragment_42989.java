"mappings" : {
  "doc" : {
     "properties" : {
        "filename" : {
           "type" : "text",
           "search_analyzer" : "filename_search",
           "analyzer" : "filename_index"              <-- change this
        }
     }
  }
}