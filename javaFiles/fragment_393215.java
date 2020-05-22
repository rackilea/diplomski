PUT events/dates/_mapping
{
  "dates" : {
    "properties" : {
      "lenient_date" : {
        "type" : "date",
        "ignore_malformed" : true
      }
    }
  }
}