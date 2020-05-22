POST _search 
{
   "aggs": {
      "genders": {
         "terms": {
            "field": "gender"
         },
         "aggs": {
            "top_tag_hits": {
               "top_hits": {
                  "_source": {
                     "include": [
                        "include_fields_name"
                     ]
                  },
                  "size": 100
               }
            }
         }
      }
   }
}