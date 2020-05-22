POST test/scores/_search
{
  "sort":{
    "_script":{
      "lang":"groovy",
      "script" : "doc['priority1'].value == 0 ? doc['priority2'].value : doc['priority1'].value",
      "type" : "number",
      "order" : "asc"
    }
  }
}