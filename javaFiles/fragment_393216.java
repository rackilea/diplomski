PUT events/dates/1
{
  "lenient_date" : "1/32/2014"
}
GET events/dates/1
Result: now works
{
   "_index": "events",
   "_type": "dates",
   "_id": "1",
   "_version": 1,
   "found": true,
   "_source": {
      "lenient_date": "1/32/2014"
   }
}