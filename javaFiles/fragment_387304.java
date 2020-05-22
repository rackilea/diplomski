> db.keywords.insert({
...     "_id": {
...         "$oid": "53cd13a4e4b0d5282d586abf"
...     },
...     "name": "musculación",
...     "categoryId": {
...         "$oid": "54180551d98ed9a5334110b3"
...     },
...     "photo": null,
...     "created": {
...         "$date": "2014-07-21T13:20:36.056Z"
...     },
...     "updated": {
...         "$date":"2016-09-27T16:17:36.692Z"
...     }
... })
2016-11-17T10:13:18.263-0500 E QUERY    [thread1] Error: field names cannot start with $ [$oid] :
DBCollection.prototype._validateForStorage@src/mongo/shell/collection.js:185:1
DBCollection.prototype._validateForStorage@src/mongo/shell/collection.js:189:13
Bulk/this.insert@src/mongo/shell/bulk_api.js:646:9
DBCollection.prototype.insert@src/mongo/shell/collection.js:271:13
@(shell):1:1