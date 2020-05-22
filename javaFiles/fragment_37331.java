GET articles/_search
{
   "query" : {
      "match" : {
         "filename" : {
           "query": "series1333372 doc623258",
            "operator" : "and"
         }
      }
   }
}